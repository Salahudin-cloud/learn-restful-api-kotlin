package com.learn_api_kotlin.learning.repository

import com.learn_api_kotlin.learning.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, String> {

    fun findByName(name: String): Product?

    override fun findById(id : String) : Optional<Product>
}