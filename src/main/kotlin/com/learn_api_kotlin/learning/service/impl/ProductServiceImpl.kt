package com.learn_api_kotlin.learning.service.impl

import com.learn_api_kotlin.learning.entity.Product
import com.learn_api_kotlin.learning.model.CreateProductRequest
import com.learn_api_kotlin.learning.model.ProductResponse
import com.learn_api_kotlin.learning.repository.ProductRepository
import com.learn_api_kotlin.learning.service.ProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(val productRepository : ProductRepository) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Product(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null

        )

        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}