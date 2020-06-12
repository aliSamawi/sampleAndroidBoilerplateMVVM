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

    @Query("DELETE FROM user")
    abstract fun delete()

    @Query("SELECT COUNT(id) FROM user")
    abstract fun getCount(): Int?
}