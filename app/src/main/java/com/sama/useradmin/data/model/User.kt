package com.sama.useradmin.data.model

data class User(
    val id : Int,
    val role : USER_ROLE,
    val username : String,
    val password: String,
    val image: String
)

enum class USER_ROLE(val type:String){
    REGULAR("regular"),
    ADMIN("string")
}