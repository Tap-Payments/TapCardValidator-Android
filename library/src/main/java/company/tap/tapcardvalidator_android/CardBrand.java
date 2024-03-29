package company.tap.tapcardvalidator_android;

import com.google.gson.annotations.SerializedName;

/**
 * TapCardValidator
 * <p>
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

// Card Brand.
public enum CardBrand {

    @SerializedName("aiywaLoyalty")                                     aiywaLoyalty("aiywaLoyalty"),
    @SerializedName(value = "AMERICAN_EXPRESS", alternate = {"AMEX"})   americanExpress("AMERICAN_EXPRESS"),
    @SerializedName("BENEFIT")                                          benefit("BENEFIT"),
    @SerializedName("CARDGUARD")                                        cardGuard("CARDGUARD"),
    @SerializedName("CBK")                                              cbk("CBK"),
    @SerializedName("DANKORT")                                          dankort("DANKORT"),
    @SerializedName("DISCOVER")                                         discover("DISCOVER"),
    @SerializedName(value = "DINERS_CLUB", alternate = {"DINERS"})      dinersClub("DINERS_CLUB"),
    @SerializedName("FAWRY")                                            fawry("FAWRY"),
    @SerializedName("INSTAPAY")                                         instaPayment("INSTAPAY"),
    @SerializedName("INTERPAY")                                         interPayment("INTERPAY"),
    @SerializedName("JCB")                                              jcb("JCB"),
    @SerializedName("KNET")                                             knet("KNET"),
    @SerializedName("MADA")                                             mada("MADA"),
    @SerializedName("MAESTRO")                                          maestro("MAESTRO"),
    @SerializedName("MASTERCARD")                                       masterCard("MASTERCARD"),
    @SerializedName("NAPS")                                             naps("NAPS"),
    @SerializedName("NSPK")                                             nspkMir("NSPK"),
    @SerializedName(value = "OMANNET", alternate = {"OMAN_NET"})        omanNet("OMANNET"),
    @SerializedName("STC_PAY")                                          stcPay("STC_PAY"),
    @SerializedName("SADAD_ACCOUNT")                                    sadad("SADAD_ACCOUNT"),
    @SerializedName("TAP")                                              tap("TAP"),
    @SerializedName("UATP")                                             uatp("UATP"),
    @SerializedName(value = "UNION_PAY", alternate = {"UNIONPAY"})      unionPay("UNION_PAY"),
    @SerializedName("VERVE")                                            verve("VERVE"),
    @SerializedName("VISA")                                             visa("VISA"),
    @SerializedName("Viva PAY")                                         viva("Viva PAY"),
    @SerializedName("Wataniya PAY")                                     wataniya("Wataniya PAY"),
    @SerializedName("Zain PAY")                                         zain("Zain PAY"),
    @SerializedName("Ooredoo PAY")                                      ooredoo("Ooredoo PAY"),
    @SerializedName("Pay later with Tabby")                             tabbypaylater("Pay later with Tabby"),
    @SerializedName("Pay in Installments with Tabby")                   tabbypayinstallments("Pay in Installments with Tabby"),
    @SerializedName("MEEZA")                                             meeza("MEEZA"),
    @SerializedName("VISA_ELECTRON")                                    visaElectron("VISA_ELECTRON"),
    @SerializedName("Careem Pay")                                        careemPay("Careem Pay"),
    @SerializedName("Buy with Careem Pay")                                        BuyWithcareemPay("Buy with Careem Pay"),
    @SerializedName("Google Pay")                                        googlePay("Google Pay"),
    @SerializedName("PayPal")                                        payPal("PayPal"),
    @SerializedName("PostPal")                                        postPal("PostPal"),
    @SerializedName("SAMSUNGPAY")                                        SAMSUNGPAY("SAMSUNGPAY"),
    @SerializedName("SAMSUNG_PAY")                                        SAMSUNG_PAY("SAMSUNG_PAY"),

    @SerializedName("")                                                 unknown("");


    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    private String rawValue;
    CardBrand(String rawValue) {

        this.rawValue = rawValue;
    }

    public String getRawValue() { return rawValue; }

    public static CardBrand fromString(String text) {
        for (CardBrand brand : CardBrand.values()) {
            if (brand.rawValue.equalsIgnoreCase(text)) {
                return brand;
            }
        }
        throw new IllegalArgumentException("No constant with raw value " + text + " found");
    }
}