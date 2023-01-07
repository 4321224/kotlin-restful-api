package springbootkotlin.restfullapi.controller


import org.springframework.web.bind.annotation.*
import springbootkotlin.restfullapi.model.*
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
            code = 201,
            status = "OK",
            data = productResponse
        )
    }
    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id:String): WebResponse<ProductResponse> {
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
                      @RequestBody updateProduct: UpdateProduct): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProduct)
        return  WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String>{
        productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id

        )
    }
    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun lisProducts(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<ProductResponse>>{
        val request = ListProduct(page = page, size = size)
        val responses = productService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}