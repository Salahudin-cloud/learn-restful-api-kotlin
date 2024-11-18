package com.learn_api_kotlin.learning.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.util.*

data class ProductResponse(

    val id :String,


    var name : String,


    var price : Long,


    var quantity : Int,


    val createdAt : Date,

    var updatedAt : Date?
)
