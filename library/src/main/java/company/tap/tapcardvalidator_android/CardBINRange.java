package company.tap.tapcardvalidator_android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * TapCardValidator
 *
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

//Card BIN range.
class CardBINRange {
    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_PAD = "0";

    // Lower card number prefix.
    private String lowerRange;

    // Higher card number prefix.
    private String higherRange;

    // Required card number length.
    private int[] cardNumberLengths;

    // Card brand.
    private CardBrand cardBrand;

    private static ArrayList<CardBINRange> allRanges;

    private static CardBINRange generalRange = new CardBINRange(EMPTY_STRING, EMPTY_STRING, new int[]{16}, CardBrand.unknown);

    private CardBINRange(String lowRange, String highRange, int[] lengths, CardBrand brand){
        lowerRange = lowRange;
        higherRange = highRange;
        cardNumberLengths = lengths;
        cardBrand = brand;
    }

    static {
        allRanges = new ArrayList<>();

        allRanges.add(new CardBINRange("34"    , "34"    , new int[]{15}                            , CardBrand.americanExpress));
        allRanges.add(new CardBINRange("37"    , "37"    , new int[]{15}                            , CardBrand.americanExpress));

        allRanges.add(new CardBINRange("62"    , "62"    , new int[]{16, 17, 18, 19}                , CardBrand.unionPay));

        allRanges.add(new CardBINRange("2014"  , "2014"  , new int[]{15}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("2149"  , "2149"  , new int[]{15}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("300"   , "305"   , new int[]{14}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("3095"  , "3095"  , new int[]{14}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("36"    , "36"    , new int[]{14}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("38"    , "39"    , new int[]{14}                            , CardBrand.dinersClub));
        allRanges.add(new CardBINRange("54"    , "55"    , new int[]{16}                            , CardBrand.dinersClub));

        allRanges.add(new CardBINRange("60110" , "60110" , new int[]{16}                            , CardBrand.discover));
        allRanges.add(new CardBINRange("60112" , "60114" , new int[]{16}                            , CardBrand.discover));
        allRanges.add(new CardBINRange("601174", "601174", new int[]{16}                            , CardBrand.discover));
        allRanges.add(new CardBINRange("601177", "601179", new int[]{16}                            , CardBrand.discover));
        allRanges.add(new CardBINRange("601186", "601199", new int[]{16}                            , CardBrand.discover));
        allRanges.add(new CardBINRange("622126", "622925", new int[]{16, 19}                        , CardBrand.discover));
        allRanges.add(new CardBINRange("644"   , "659"   , new int[]{16}                            , CardBrand.discover));

        allRanges.add(new CardBINRange("636"   , "636"   , new int[]{16, 17, 18, 19}                , CardBrand.interPayment));

        allRanges.add(new CardBINRange("637"   , "639"   , new int[]{16}                            , CardBrand.instaPayment));

        allRanges.add(new CardBINRange("1800"  , "1800"  , new int[]{16, 17, 18, 19}                , CardBrand.jcb));
        allRanges.add(new CardBINRange("2131"  , "2131"  , new int[]{16, 17, 18, 19}                , CardBrand.jcb));
        allRanges.add(new CardBINRange("3528"  , "3589"  , new int[]{16, 17, 18, 19}                , CardBrand.jcb));

        allRanges.add(new CardBINRange("50"    , "50"    , new int[]{12, 13, 14, 15, 16, 17, 18, 19}, CardBrand.maestro));
        allRanges.add(new CardBINRange("56"    , "64"    , new int[]{12, 13, 14, 15, 16, 17, 18, 19}, CardBrand.maestro));
        allRanges.add(new CardBINRange("66"    , "69"    , new int[]{12, 13, 14, 15, 16, 17, 18, 19}, CardBrand.maestro));

        allRanges.add(new CardBINRange("5019"  , "5019"  , new int[]{16}                            , CardBrand.dankort));
        allRanges.add(new CardBINRange("4175"  , "4175"  , new int[]{16}                            , CardBrand.dankort));
        allRanges.add(new CardBINRange("4571"  , "4571"  , new int[]{16}                            , CardBrand.dankort));

        allRanges.add(new CardBINRange("2200"  , "2204"  , new int[]{16}                            , CardBrand.nspkMir));

        allRanges.add(new CardBINRange("51"    , "55"    , new int[]{16}                            , CardBrand.masterCard));
        allRanges.add(new CardBINRange("2221"  , "2720"  , new int[]{16}                            , CardBrand.masterCard));

        allRanges.add(new CardBINRange("4"     , "4"     , new int[]{16}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("413600", "413600", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("444509", "444509", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("444550", "444550", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450603", "450603", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450617", "450617", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450628", "450629", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450636", "450636", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450640", "450641", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("450662", "450662", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("463100", "463100", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("476142", "476143", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492901", "492902", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492920", "492920", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492923", "492923", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492928", "492930", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492937", "492937", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492939", "492939", new int[]{13}                            , CardBrand.visa));
        allRanges.add(new CardBINRange("492960", "492960", new int[]{13}                            , CardBrand.visa));

        allRanges.add(new CardBINRange("1"     , "1"     , new int[]{15}                            , CardBrand.uatp));

        allRanges.add(new CardBINRange("506099", "506198", new int[]{16, 19}                        , CardBrand.verve));
        allRanges.add(new CardBINRange("650002", "650027", new int[]{16, 19}                        , CardBrand.verve));

        allRanges.add(new CardBINRange("5392"  , "5392"  , new int[]{16}                            , CardBrand.cardGuard));
    }

    static CardBINRange mostSpecific(String number) {
        return mostSpecific(number, null);
    }

    static CardBINRange mostSpecific(String number, ArrayList<CardBrand> preferredBrands) {
        ArrayList<CardBrand> nonnullPreferredBrands = preferredBrands == null ? new ArrayList<>() : preferredBrands;
        boolean preferredBrandsAreNotEmpty = nonnullPreferredBrands.size() > 0;

        ArrayList<CardBINRange> possibleRanges = new ArrayList<>();

        for (CardBINRange range : allRanges) {
            if (preferredBrandsAreNotEmpty && !nonnullPreferredBrands.contains(range.cardBrand)) {
                continue;
            }
            if (range.matches(number)) {
                possibleRanges.add(range);
            }
        }

        if (possibleRanges.size() == 0) {
            return generalRange;
        }

        int numberLength = number.length();
        
        ArrayList<CardBINRange> possibleRangesWithMostCloseRangeLengthFromLeft = new ArrayList<>();
        for (CardBINRange range : possibleRanges) {
            if (range.lowerRange.length() <= numberLength) {
                possibleRangesWithMostCloseRangeLengthFromLeft.add(range);
            }
        }

        if (possibleRangesWithMostCloseRangeLengthFromLeft.size() > 0) {
            ArrayList<CardBINRange> sortedByLengthPossibleRanges = new ArrayList<>();
            sortedByLengthPossibleRanges.addAll(possibleRangesWithMostCloseRangeLengthFromLeft);
            Collections.sort(sortedByLengthPossibleRanges, (t0, t1) -> t0.lowerRange.length() == t1.lowerRange.length() ? 0 : t0.lowerRange.length() < t1.lowerRange.length() ? 1 : -1);

            int maxLength = sortedByLengthPossibleRanges.get(0).lowerRange.length();

            ArrayList<CardBINRange> allMaxLengthRanges = new ArrayList<>();
            for (CardBINRange range : sortedByLengthPossibleRanges) {
                if (range.lowerRange.length() == maxLength) {
                    allMaxLengthRanges.add(range);
                }
            }

            ArrayList<CardBINRange> sortedMaxLengthRanges = new ArrayList<>();
            sortedMaxLengthRanges.addAll(allMaxLengthRanges);
            Collections.sort(sortedMaxLengthRanges, (t0, t1) -> {
                int t0Index = nonnullPreferredBrands.indexOf(t0.cardBrand);
                int t1Index = nonnullPreferredBrands.indexOf(t1.cardBrand);

                if (t0Index == -1) {
                    t0Index = nonnullPreferredBrands.size() + 1;
                }
                if (t1Index == -1) {
                    t1Index = nonnullPreferredBrands.size() + 1;
                }

                return t0Index == t1Index ? 0 : t0Index > t1Index ? 1 : -1;
            });

            return sortedMaxLengthRanges.get(0);
        }
        
        ArrayList<CardBINRange> possibleRangesWithMostCloseRangeLengthFromRight = new ArrayList<>();
        for (CardBINRange range : possibleRanges) {
            if (range.lowerRange.length() > numberLength) {
                possibleRangesWithMostCloseRangeLengthFromRight.add(range);
            }
        }

        if (possibleRangesWithMostCloseRangeLengthFromRight.size() > 0) {
            ArrayList<CardBINRange> sortedByLengthPossibleRanges = new ArrayList<>();
            sortedByLengthPossibleRanges.addAll(possibleRangesWithMostCloseRangeLengthFromRight);
            Collections.sort(sortedByLengthPossibleRanges, (t0, t1) -> t0.lowerRange.length() == t1.lowerRange.length() ? 0 : t0.lowerRange.length() > t1.lowerRange.length() ? 1 : -1);

            int minLength = sortedByLengthPossibleRanges.get(0).lowerRange.length();

            ArrayList<CardBINRange> allMinLengthRanges = new ArrayList<>();
            for (CardBINRange range : sortedByLengthPossibleRanges) {
                if (range.lowerRange.length() == minLength) {
                    allMinLengthRanges.add(range);
                }
            }

            ArrayList<CardBINRange> sortedMinLengthRanges = new ArrayList<>();
            sortedMinLengthRanges.addAll(allMinLengthRanges);
            Collections.sort(sortedMinLengthRanges, (t0, t1) -> {
                int t0Index = nonnullPreferredBrands.indexOf(t0.cardBrand);
                int t1Index = nonnullPreferredBrands.indexOf(t1.cardBrand);

                if (t0Index == -1) {
                    t0Index = nonnullPreferredBrands.size() + 1;
                }
                if (t1Index == -1) {
                    t1Index = nonnullPreferredBrands.size() + 1;
                }

                return t0Index == t1Index ? 0 : t0Index > t1Index ? 1 : -1;
            });

            return sortedMinLengthRanges.get(0);
        }

        return generalRange;
    }

    static CardBrand brand(String number){
        LinkedHashSet<CardBrand> brands = possibleBrands(number);

        if (brands.size() == 1) {
            return brands.toArray(new CardBrand[brands.size()])[0];
        } else {
            return CardBrand.unknown;
        }
    }

    static LinkedHashSet<CardBrand> possibleBrands(String number){
        LinkedHashSet<CardBrand> possibleBrands = new LinkedHashSet<>();

        for (CardBINRange cardRange : binRanges(number)) {
            possibleBrands.add(cardRange.cardBrand);
        }
        possibleBrands.remove(CardBrand.unknown);

        return possibleBrands;
    }

    private static ArrayList<CardBINRange> binRanges(String number) {
        ArrayList<CardBINRange> result = new ArrayList<>();

        for (CardBINRange cardRange : allRanges) {
            if (cardRange.matches(number)) {
                result.add(cardRange);
            }
        }

        return result;
    }

    private boolean matches(String number) {
        int lowLength = Math.min(number.length(), lowerRange.length());
        int highLength = Math.min(number.length(), higherRange.length());

        int numberLow;
        int numberHigh;
        int selfLow;
        int selfHigh;

        try {
            numberLow = Integer.parseInt(padRight(number, lowLength));
            numberHigh = Integer.parseInt(padRight(number, highLength));

            selfLow = Integer.parseInt(padRight(lowerRange, lowLength));
            selfHigh = Integer.parseInt(padRight(higherRange, highLength));
        } catch (NumberFormatException ex) {
            return false;
        }

        return selfLow <= numberLow && selfHigh >= numberHigh;
    }

    private boolean matchesMostSpecific(String number) {
        int low;
        int high;
        int selfLow;
        int selfHigh;

        try {
            low = Integer.parseInt(padRight(number, lowerRange.length()));
            high = Integer.parseInt(padRight(number, higherRange.length()));

            selfLow = Integer.parseInt(lowerRange);
            selfHigh = Integer.parseInt(higherRange);
        } catch (NumberFormatException ex) {
            return false;
        }

        return selfLow <= low && selfHigh >= high;
    }

    private static String padRight(String s, int n) {
        return s.length() == n ?
                s : s.length() > n ?
                s.substring(0, n) : String.format("%1$-" + n + "s", s).replace(" ", DEFAULT_PAD);
    }

    CardBrand getCardBrand() {
        return cardBrand;
    }

    int[] getCardNumberLengths() {
        return cardNumberLengths;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CardBINRange)) {
            return false;
        }

        CardBINRange another = (CardBINRange) o;
        return this.lowerRange.equals(another.lowerRange)
                && this.higherRange.equals(another.higherRange)
                && Arrays.equals(this.cardNumberLengths, another.cardNumberLengths)
                && this.cardBrand == another.cardBrand;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + lowerRange.hashCode();
        result = 31 * result + higherRange.hashCode();
        result = 31 * result + Arrays.hashCode(cardNumberLengths);
        result = 31 * result + cardBrand.hashCode();

        return result;
    }
}
