package com.sama.useradmin.data.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sama.useradmin.data.model.User


@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)

    @Query("UPDATE user SET email=:newEmail AND password=:newPassword WHERE email = :prevEmail")
    abstract fun update(prevEmail: String, newEmail:String, newPassword:String)


    @Query("SELECT * FROM  user")
    abstract fun getRegularUser(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    abstract fun getUser(email:String, password:String): LiveData<User?>

    @Query("DELETE FROM user WHERE email = :email")
    abstract fun delete(email:String)
}