package com.example.zykov.bankapp.utilites

import com.example.zykov.bankapp.MainActivity
import com.example.zykov.bankapp.parser.Repository

lateinit var APP_ACTIVITY: MainActivity
const val BASE_URL = "https://www.cbr-xml-daily.ru/"
lateinit var PARSER: Repository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var EMAIL: String
lateinit var PASSWORD: String
lateinit var PHONE_NUMBER: String
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"