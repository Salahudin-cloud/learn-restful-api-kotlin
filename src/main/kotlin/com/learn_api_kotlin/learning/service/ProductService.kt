package com.learn_api_kotlin.learning.service

import com.learn_api_kotlin.learning.model.CreateProductRequest
import com.learn_api_kotlin.learning.model.ProductResponse

interface ProductService {
    fun create(createProductRequest : CreateProductRequest) : ProductResponse
}