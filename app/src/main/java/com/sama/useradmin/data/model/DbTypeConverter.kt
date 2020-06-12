package com.sama.useradmin.data.model

import androidx.room.TypeConverter
import java.lang.StringBuilder

object DbTypeConverter {
    @TypeConverter
    @JvmStatic
    fun RoleToString(role: USER_ROLE): String? {
        return try {
            val builder = StringBuilder()
            builder.append(role.type)
            builder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    @TypeConverter
    @JvmStatic
    fun stringToRole(data: String?): USER_ROLE? {
        try {
            if (data == null) return null
            return if(data == USER_ROLE.ADMIN.type)
                USER_ROLE.ADMIN
            else
                USER_ROLE.REGULAR
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

}