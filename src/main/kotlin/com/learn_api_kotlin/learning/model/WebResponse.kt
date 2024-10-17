package com.learn_api_kotlin.learning.model

data class WebResponse<T> (
    val code : Int,
    val status : String,
    val data : T
)