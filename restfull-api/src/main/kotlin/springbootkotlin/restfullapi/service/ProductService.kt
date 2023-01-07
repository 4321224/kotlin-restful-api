package springbootkotlin.restfullapi.service

import springbootkotlin.restfullapi.model.CreateProduct
import springbootkotlin.restfullapi.model.ListProduct
import springbootkotlin.restfullapi.model.ProductResponse
import springbootkotlin.restfullapi.model.UpdateProduct

interface ProductService {
    fun create(createProduct: CreateProduct): ProductResponse
    fun get(id: String): ProductResponse
    fun update(id:String, updateProduct: UpdateProduct): ProductResponse
    fun delete(id:String)
    fun list(listProduct: ListProduct): List<ProductResponse>
}