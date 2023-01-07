package springbootkotlin.restfullapi.model

import java.util.*
data class ProductResponse(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createAt: Date,
    val updateAt: Date
)
