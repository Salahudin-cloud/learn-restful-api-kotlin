package com.learn_api_kotlin.learning.repository

import com.learn_api_kotlin.learning.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}