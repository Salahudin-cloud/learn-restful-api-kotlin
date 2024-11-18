package com.learn_api_kotlin.learning.validation


import jakarta.validation.ConstraintViolationException
import org.springframework.stereotype.Component
import jakarta.validation.Validator

@Component
class ValidationUtils ( val validator : Validator){
    fun validate(any: Any){
        val result = validator.validate(any)
        if (result.isNotEmpty()) {
            throw ConstraintViolationException(result)
        }
    }

}