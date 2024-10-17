package com.learn_api_kotlin.learning.repository

import com.learn_api_kotlin.learning.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> { // JpaRepository< database name , id table? >
}