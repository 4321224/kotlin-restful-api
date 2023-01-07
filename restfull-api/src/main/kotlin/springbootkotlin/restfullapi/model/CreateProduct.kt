package springbootkotlin.restfullapi.model


data class CreateProduct(
    val id : String?,
    val name: String?,
    val price: Long?,
    val quantity: Int?
)
