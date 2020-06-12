package com.sama.useradmin.data.model

import androidx.room.Entity
import androidx.room.Index

@Entity(
    indices = [Index("id")],
    primaryKeys = ["id"]
)
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