package com.sama.useradmin.data.repository.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sama.useradmin.data.model.User


@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)

    @Query("SELECT * FROM  user")
    abstract fun getRegularUser(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    abstract fun getUser(email:String, password:String): LiveData<User?>

    @Query("DELETE FROM user")
    abstract fun delete()
}