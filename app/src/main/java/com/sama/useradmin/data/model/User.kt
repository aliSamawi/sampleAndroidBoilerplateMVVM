package com.sama.useradmin.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

@Entity(
    indices = [Index("email")],
    primaryKeys = ["email"]
)
@TypeConverters(DbTypeConverter::class)
@Parcelize
data class User(
    val role : USER_ROLE,
    val fullname : String,
    val email : String,
    val password: String,
    val image: String
) : Parcelable

enum class USER_ROLE(val type:String){
    REGULAR("regular"),
    ADMIN("string")
}