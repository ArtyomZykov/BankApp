package com.example.zykov.bankapp.models

import android.util.Log
import java.io.Serializable
import java.util.*

data class AppObject(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Valutes,
)

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
    val ID: String,
    val NumCode: String,
    val CharCode: String,
    val Nominal: Int,
    val Name: String,
    val Value: Double,
    val Previous: Double,
) : Serializable