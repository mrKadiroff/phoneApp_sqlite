package com.example.phone.DBhelper

import com.example.phone.models.Phone

interface DataBaseServise {
    fun addPhone (phone: Phone)
    fun getPhonesByModel() : ArrayList<Phone>
}