package company.tap.tapcardvalidator_android;

/**
 * TapCardValidator
 *
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

// Card Brand.
public enum CardBrand {
    aiywaLoyalty ("Aiywa Loyalty"),
    americanExpress ("AMEX"),
    cardGuard ("CARDGUARD"),
    cbk ("CBK"),
    dankort ("DANKORT"),
    discover ("DISCOVER"),
    dinersClub ("DINERS"),
    instaPayment ("INSTAPAY"),
    interPayment ("INTERPAY"),
    jcb ("JCB"),
    knet ("KNET"),
    maestro ("MAESTRO"),
    masterCard ("MASTERCARD"),
    nspkMir ("NSPK"),
    tap ("TAP"),
    uatp ("UATP"),
    unionPay ("UNIONPAY"),
    verve ("VERVE"),
    visa ("VISA"),
    viva ("Viva PAY"),
    wataniya ("Wataniya PAY"),
    zain ("Zain PAY"),

    unknown("");

    private String value;

    CardBrand(String value) {
        this.value = value;
    }
}
