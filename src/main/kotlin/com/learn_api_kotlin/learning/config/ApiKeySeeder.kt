package com.learn_api_kotlin.learning.config

import com.learn_api_kotlin.learning.entity.ApiKey
import com.learn_api_kotlin.learning.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)) { // if does not  have api key will save it
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}