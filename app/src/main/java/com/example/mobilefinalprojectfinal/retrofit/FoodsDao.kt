package com.example.mobilefinalprojectfinal.retrofit

import android.widget.ImageView
import com.example.mobilefinalprojectfinal.data.entity.Foods
import com.example.mobilefinalprojectfinal.data.entity.SepetFoodsResponse
import retrofit2.http.GET

interface FoodsDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/
    //yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun loadFoods() : SepetFoodsResponse

}