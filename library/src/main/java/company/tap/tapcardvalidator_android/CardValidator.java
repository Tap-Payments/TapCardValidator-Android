package company.tap.tapcardvalidator_android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * TapCardValidator
 *
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

public class CardValidator {
    private static final String WHITESPACE_REGEX = "[\u0009" +
            "\u0020" +
            "\u00A0" +
            "\u1680" +
            "\u2000" +
            "\u2001" +
            "\u2002" +
            "\u2003" +
            "\u2004" +
            "\u2005" +
            "\u2006" +
            "\u2007" +
            "\u2008" +
            "\u2009" +
            "\u200A" +
            "\u202F" +
            "\u205F" +
            "\u3000]+";
    private static final String INTERNATIONAL_DIGITS_SET = "0123456789";

    /**
     * Validates card number.
     *
     * @param cardNumber: Card number.
     * @return Card brand with its validation state.
     */
    public static DefinedCardBrand validate(String cardNumber) {
        return validate(cardNumber, null);
    }

    /**
     * Validates card number with preferred brands.
     *
     * @param cardNumber: Card number.
     * @param preferredBrands: Preferred brands.
     * @return Card brand with its validation state.
     */
    public static DefinedCardBrand validate(String cardNumber, ArrayList<CardBrand> preferredBrands) {
        String number = cardNumber.replaceAll(WHITESPACE_REGEX, "");
        if (number.isEmpty()) {
            return new DefinedCardBrand(CardValidationState.incomplete, null);
        }
        if (!containsOnlyInternationalDigits(number)) {
            return new DefinedCardBrand(CardValidationState.invalid, null);
        }

        CardBINRange binRange = CardBINRange.mostSpecific(number, preferredBrands);
        CardBrand cardBrand = binRange.getCardBrand();

        if (preferredBrands != null && preferredBrands.size() > 0  && cardBrand == CardBrand.unknown) {
            binRange = CardBINRange.mostSpecific(number);
            cardBrand = binRange.getCardBrand();
        }

        if (cardBrand == CardBrand.unknown) {
            return new DefinedCardBrand(CardValidationState.invalid, null);
        }

        if (arrayContains(binRange.getCardNumberLengths(), number.length())) {
            return new DefinedCardBrand(passesLuhn(number) ? CardValidationState.valid : CardValidationState.invalid, cardBrand);
        } else if (number.length() > arrayMax(binRange.getCardNumberLengths())) {
            return new DefinedCardBrand(CardValidationState.invalid, cardBrand);
        } else {
            return new DefinedCardBrand(CardValidationState.incomplete, cardBrand);
        }
    }


    public int getCardLength(CardBrand cardBrand){
        List<CardBINRange> cardBINRanges = CardBINRange.ranges(cardBrand);
        if(cardBINRanges.isEmpty()){
            return 0;
        }else {
            int[] dummy  = CardBINRange.ranges(cardBrand).get(0).getCardNumberLengths();
            if (dummy.length == 0){
                return 0;
            }else {
               // return  Collections.max(Arrays.asList(dummy));
                return  dummy[0];
            }
        }
    }

    /**
     * Returns correct visual spacings for a given card brand.
     *
     * @param card: Card brand.
     * @return Visual spacings for a given brand.
     */

    public static int[] spacings(CardBrand card) {
        if (card == CardBrand.americanExpress) {
            return new int[] {3, 9};
        } else {
            return new int[] {3, 7, 11};
        }
    }

    /**
     * Returns required cvv length for a given card brand.
     * @param card: Card brand.
     * @return required cvv field length.
     */

    public static int cvvLength(CardBrand card) {
        if (card == null || card == CardBrand.unknown || card == CardBrand.americanExpress) {
            return 4;
        }
        else {
            return 3;
        }
    }

    /**
     * Returns possible card brand to pay through for a given card number among allowed brands.
     * @param cardNumber: Card number.
     * @param brands: Available card brands.
     * @return Returns: Card brand or nil.
     */

    public static CardBrand paymentCardBrand(String cardNumber, CardBrand[] brands) {
        String number = cardNumber.replaceAll(WHITESPACE_REGEX, "");
        if (number.length() == 0 || !containsOnlyInternationalDigits(number)) {
            return null;
        }

        LinkedHashSet<CardBrand> possibleBrands = CardBINRange.possibleBrands(number);
        for (CardBrand cardBrand : possibleBrands) {
            if (collectionContains(brands, cardBrand)) {
                return cardBrand;
            }
        }
        return null;
    }

    private static String trimmingCharacters(String string, String regex) {
        return string.replaceAll("^" + regex, "").replaceAll(regex + "$", "");
    }

    private static boolean containsOnlyInternationalDigits(String string) {
        String nonDigitsRegex = "[^" + INTERNATIONAL_DIGITS_SET + "]";
        return string.replaceAll(nonDigitsRegex, "").length() == string.length();
    }

    private static boolean passesLuhn(String number) {
        int sum = 0;
        String reversedNumber = new StringBuilder(number).reverse().toString();

        for (int i = 0; i < reversedNumber.length(); i++){
            char c = reversedNumber.charAt(i);
            int digit = Character.getNumericValue(c);
            if (digit < 0) {
                return false;
            }

            boolean odd = i % 2 == 1;
            if (odd && digit >= 0 && digit <= 8) {
                sum += (digit * 2) % 9;
            } else {
                sum += digit;
            }
        }

        return sum % 10 == 0;
    }

    private static boolean arrayContains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }

        return false;
    }

    private static <T> boolean collectionContains(T[] arr, T value) {
        for (T i : arr) {
            if (i == value || i.equals(value)) {
                return true;
            }
        }

        return false;
    }

    private static int arrayMax(int[] arr) {
        int value = arr[0];
        for (int i : arr) {
            if (i > value) {
                value = i;
            }
        }

        return value;
    }
  /*  public static int maximalCardNumberLength(CardBrand brand) {
        List<CardBINRange> ranges =  CardBINRange.ranges(brand);
        List<Integer> lengths = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            lengths = ranges.stream()
                    .flatMap(range->range.getCardNumberLengths().)
                    .collect(Collectors.toList());

            OptionalInt max = lengths.stream().mapToInt(Integer::intValue).max();

            return max.orElse(0);
        }
        else return 0;
    }*/
}
