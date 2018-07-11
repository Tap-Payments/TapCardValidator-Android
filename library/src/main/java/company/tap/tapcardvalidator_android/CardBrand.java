package company.tap.tapcardvalidator_android;

import com.google.gson.annotations.SerializedName;

/**
 * TapCardValidator
 * <p>
 * Copyright © 2018 Tap Payments. All rights reserved.
 */

// Card Brand.
public enum CardBrand {

    @SerializedName("aiywaLoyalty") aiywaLoyalty,
    @SerializedName(value = "AMEX", alternate = {"AMERICAN_EXPRESS"}) americanExpress,
    @SerializedName("BENEFIT") benefit,
    @SerializedName("CARDGUARD") cardGuard,
    @SerializedName("CBK") cbk,
    @SerializedName("DANKORT") dankort,
    @SerializedName("DISCOVER") discover,
    @SerializedName(value = "DINERS_CLUB", alternate = {"DINERS"}) dinersClub,
    @SerializedName("FAWRY") fawry,
    @SerializedName("INSTAPAY") instaPayment,
    @SerializedName("INTERPAY") interPayment,
    @SerializedName("JCB") jcb,
    @SerializedName("KNET") knet,
    @SerializedName("MADA") mada,
    @SerializedName("MAESTRO") maestro,
    @SerializedName("MASTERCARD") masterCard,
    @SerializedName("NAPS") naps,
    @SerializedName("NSPK") nspkMir,
    @SerializedName("SADAD_ACCOUNT") sadad,
    @SerializedName("TAP") tap,
    @SerializedName("UATP") uatp,
    @SerializedName(value = "UNION_PAY", alternate = {"UNIONPAY"}) unionPay,
    @SerializedName("VERVE") verve,
    @SerializedName("VISA") visa,
    @SerializedName("Viva PAY") viva,
    @SerializedName("Wataniya PAY") wataniya,
    @SerializedName("Zain PAY") zain,
    @SerializedName("") unknown
}
