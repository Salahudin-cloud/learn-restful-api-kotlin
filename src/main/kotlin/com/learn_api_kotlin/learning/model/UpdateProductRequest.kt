package com.learn_api_kotlin.learning.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateProductRequest (
    @field:NotBlank
    var name : String?,

    @field:NotNull
    @field:Min(value = 1)
    var price : Long?,

    @field:NotNull
    @field:Min(value = 0)
    var quantity : Int?
)