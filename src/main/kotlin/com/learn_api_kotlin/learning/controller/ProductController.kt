package com.learn_api_kotlin.learning.controller

import com.learn_api_kotlin.learning.model.CreateProductRequest
import com.learn_api_kotlin.learning.model.ProductResponse
import com.learn_api_kotlin.learning.model.WebResponse
import com.learn_api_kotlin.learning.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {
    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body : CreateProductRequest) : WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
}