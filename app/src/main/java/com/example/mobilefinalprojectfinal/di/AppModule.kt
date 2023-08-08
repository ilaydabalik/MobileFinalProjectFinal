package com.example.mobilefinalprojectfinal.di


import com.example.mobilefinalprojectfinal.data.datasource.SepetFoodsDataSource
import com.example.mobilefinalprojectfinal.data.repo.FoodsRepository
import com.example.mobilefinalprojectfinal.retrofit.ApiUtils
import com.example.mobilefinalprojectfinal.retrofit.CartFoodsDao
import com.example.mobilefinalprojectfinal.retrofit.FoodsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideFoodsDao() : FoodsDao{
        return ApiUtils.getFoodsDao()
    }

    @Provides
    @Singleton
    fun provideCartFoodsDataSource(cdao:CartFoodsDao) : SepetFoodsDataSource{
        return SepetFoodsDataSource(cdao)
    }

    @Provides
    @Singleton
    fun provideCartFoodsDao() : CartFoodsDao{
        return ApiUtils.getCartFoodsDao()
    }

}