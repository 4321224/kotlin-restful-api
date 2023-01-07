package springbootkotlin.restfullapi.controller

import org.springframework.web.bind.annotation.*
import springbootkotlin.restfullapi.model.CreateProduct
import springbootkotlin.restfullapi.model.ProductResponse
import springbootkotlin.restfullapi.model.WebResponse
import springbootkotlin.restfullapi.service.ProductService


@RestController
class ProductController (val productService: ProductService){
    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProducts(@RequestBody body: CreateProduct): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
}