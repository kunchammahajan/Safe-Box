package com.andryoga.safebox.di

import com.andryoga.safebox.data.db.secureDao.LoginDataDaoSecure
import com.andryoga.safebox.data.db.secureDao.UserDetailsDaoSecure
import com.andryoga.safebox.data.repository.LoginDataRepositoryImpl
import com.andryoga.safebox.data.repository.UserDetailsRepositoryImpl
import com.andryoga.safebox.data.repository.interfaces.LoginDataRepository
import com.andryoga.safebox.data.repository.interfaces.UserDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideUserDetailsRepo(
        userDetailsDaoSecure: UserDetailsDaoSecure
    ): UserDetailsRepository {
        return UserDetailsRepositoryImpl(
            userDetailsDaoSecure
        )
    }

    @Singleton
    @Provides
    fun provideLoginDataRepo(
        loginDataDaoSecure: LoginDataDaoSecure
    ): LoginDataRepository {
        return LoginDataRepositoryImpl(loginDataDaoSecure)
    }
}
