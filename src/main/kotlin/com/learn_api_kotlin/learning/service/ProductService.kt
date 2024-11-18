package com.learn_api_kotlin.learning.service

import com.learn_api_kotlin.learning.model.CreateProductRequest
import com.learn_api_kotlin.learning.model.ListProductRequest
import com.learn_api_kotlin.learning.model.ProductResponse
import com.learn_api_kotlin.learning.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest : CreateProductRequest) : ProductResponse

    fun get(id : String) : ProductResponse

    fun update (id: String, updateProductRequest: UpdateProductRequest) : ProductResponse

    fun delete (id: String)

    fun list(listProductRequest: ListProductRequest) : List<ProductResponse>
}