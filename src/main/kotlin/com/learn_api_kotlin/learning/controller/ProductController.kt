package com.learn_api_kotlin.learning.controller

import com.learn_api_kotlin.learning.model.*
import com.learn_api_kotlin.learning.service.ProductService
import org.springframework.web.bind.annotation.*

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

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
    )
    fun getProduct(@PathVariable("idProduct") id : String) : WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("idProduct") id: String,
                     @RequestBody body: UpdateProductRequest) : WebResponse<ProductResponse>{
        val productResponse = productService.update(id, body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
    )
    fun deleteProduct(@PathVariable("idProduct") id : String) : WebResponse<String> {
       productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = "[]"
        )
    }


    @GetMapping(
        value = ["/api/products/"],
        produces = ["application/json"],
    )
    fun listProduct(
            @RequestParam(value = "page", defaultValue = "1") page: Int,
            @RequestParam(value = "size", defaultValue = "10") size : Int,
        ) : WebResponse<List<ProductResponse>> {
        val req = ListProductRequest(page, size)
        val res = productService.list(req)
        return WebResponse(
            code = 200,
            status = "Ok",
            data = res
        )
    }
}