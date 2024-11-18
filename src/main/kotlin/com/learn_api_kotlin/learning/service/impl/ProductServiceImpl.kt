package com.learn_api_kotlin.learning.service.impl

import com.learn_api_kotlin.learning.entity.Product
import com.learn_api_kotlin.learning.exception.DataAlreadyExistsException
import com.learn_api_kotlin.learning.exception.NotFoundExeception
import com.learn_api_kotlin.learning.model.*
import com.learn_api_kotlin.learning.repository.ProductRepository
import com.learn_api_kotlin.learning.service.ProductService
import com.learn_api_kotlin.learning.validation.ValidationUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository : ProductRepository,
    val validationUtils: ValidationUtils,
) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtils.validate(createProductRequest)
        // Check if a product with the given ID already exists
        if (productRepository.findById(createProductRequest.id!!).isPresent) {
            throw DataAlreadyExistsException("Product with the ID '${createProductRequest.id}' already exists")
        }

        // Check if a product with the given name already exists
        if (productRepository.findByName(createProductRequest.name!!) != null) {
            throw DataAlreadyExistsException("Product with the name '${createProductRequest.name}' already exists")
        }

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null

        )


        productRepository.save(product)


        return responseProduct(product)

    }

    override fun get(id: String): ProductResponse {
        val product =  findProductByIdOrNull(id)
        return responseProduct(product)
    }

    override fun update(id: String, data: UpdateProductRequest): ProductResponse {
        val product =  findProductByIdOrNull(id)
        validationUtils.validate(data)

        product.apply {
            name = data.name!!
            price = data.price!!
            quantity = data.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return responseProduct(product)

    }

    override fun delete(id: String) {
        val product =  findProductByIdOrNull(id)

        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())

        return products.map { responseProduct(it) }
    }


    private fun findProductByIdOrNull(id : String) : Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null ) {
            throw NotFoundExeception()
        }else {
            return product
        }
    }



    private fun responseProduct(product: Product) : ProductResponse{
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