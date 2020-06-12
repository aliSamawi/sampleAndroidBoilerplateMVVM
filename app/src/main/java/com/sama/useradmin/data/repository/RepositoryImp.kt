package com.sama.useradmin.data.repository

import androidx.lifecycle.LiveData
import com.sama.useradmin.data.model.User
import com.sama.useradmin.data.repository.remote.CloudDataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(
//    private val cloudDataSource: CloudDataSource,
//    private val db: Db,
//    private val venueDao: UserDao
): Repository {

    override fun getRegularUsers(): LiveData<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}