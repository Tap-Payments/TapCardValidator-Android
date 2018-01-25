package company.tap.tapcardvalidator_android;

/**
 * TapCardValidator
 *
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

public class DefinedCardBrand {
    CardValidationState validationState;
    CardBrand cardBrand;

    DefinedCardBrand(CardValidationState validationState, CardBrand cardBrand) {
        this.validationState = validationState;
        this.cardBrand = cardBrand;
    }

    public CardValidationState getValidationState() {
        return validationState;
    }

    public CardBrand getCardBrand() {
        return cardBrand;
    }
}
