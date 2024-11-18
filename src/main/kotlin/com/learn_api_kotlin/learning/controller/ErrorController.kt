package com.learn_api_kotlin.learning.controller

import com.learn_api_kotlin.learning.exception.DataAlreadyExistsException
import com.learn_api_kotlin.learning.exception.NotFoundExeception
import com.learn_api_kotlin.learning.exception.UnauthorizedException
import com.learn_api_kotlin.learning.model.WebResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(ConstraintViolationException::class)
    fun validationHandler(err: ConstraintViolationException) : WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = err.message!!
        )
    }

    @ExceptionHandler(DataAlreadyExistsException::class)
    fun handleDataAlreadyExistException(err : DataAlreadyExistsException) : WebResponse<String> {
        return WebResponse(
            code = 409,
            status = "CONFLICT",
            data = err.message!!
        )
    }

    @ExceptionHandler(NotFoundExeception::class)
    fun handleNotFoundException(err : NotFoundExeception) : WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "Can't find the product",
            data = "Data not found"
        )
    }

    @ExceptionHandler(UnauthorizedException::class)
    fun unauthorizedException(err : UnauthorizedException) : WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "Unauthorized",
            data = "please put your X-api-key"
        )
    }

}