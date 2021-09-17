package com.example.zykov.bankapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AppObject(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val valute: Valutes,
) : Serializable

data class Valutes(
    val AUD: Items,
    val AZN: Items,
    val GBP: Items,
    val AMD: Items,
    val BYN: Items,
    val BGN: Items,
    val BRL: Items,
    val HUF: Items,
    val HKD: Items,
    val DKK: Items,
    val USD: Items,
    val EUR: Items,
    val INR: Items,
    val KZT: Items,
    val CAD: Items,
    val KGS: Items,
    val CNY: Items,
    val MDL: Items,
    val NOK: Items,
    val PLN: Items,
    val RON: Items,
    val XDR: Items,
    val SGD: Items,
    val TJS: Items,
    val TRY: Items,
    val TMT: Items,
    val UZS: Items,
    val UAH: Items,
    val CZK: Items,
    val SEK: Items,
    val CHF: Items,
    val ZAR: Items,
    val KRW: Items,
    val JPY: Items,
) : Serializable {
    var list: List<Items>? = null
    fun setList() {
        list = listOf(AUD, AZN, GBP, AMD, BYN, BRL, HUF, HKD, DKK, USD, EUR,
            INR, KZT, CAD, KGS, CNY, MDL, NOK, PLN, RON, XDR, SGD, TJS, TRY,
            TMT, UZS, UAH, CZK, SEK, CHF, CHF, ZAR, KRW, JPY)
    }
}

data class Items(
    @SerializedName("ID")
    val id: String,
    @SerializedName("NumCode")
    val numCode: String,
    @SerializedName("CharCode")
    val charCode: String,
    @SerializedName("Nominal")
    val nominal: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Value")
    val value: Double,
    @SerializedName("Previous")
    val previous: Double,
) : Serializable