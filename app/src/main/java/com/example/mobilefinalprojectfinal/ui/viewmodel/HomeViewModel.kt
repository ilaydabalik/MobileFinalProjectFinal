package com.example.mobilefinalprojectfinal.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilefinalprojectfinal.data.entity.Foods
import com.example.mobilefinalprojectfinal.data.entity.SepetFoods
import com.example.mobilefinalprojectfinal.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var frepo:FoodsRepository) : ViewModel(){

    var foodList = MutableLiveData<List<Foods>>()

    init {
        loadFoodsToMain()
    }

    fun loadFoodsToMain(){
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = frepo.loadFoodsToMain()
        }
    }

    fun addToCartFromMain(ad:String,fiyat:Int,resim:String){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.addToCartFromMain(ad,fiyat,resim)
        }
    }

}


