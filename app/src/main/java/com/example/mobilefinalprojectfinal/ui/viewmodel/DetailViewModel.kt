package com.example.mobilefinalprojectfinal.ui.viewmodel
import android.util.Log
import androidx.lifecycle.ViewModel

import com.example.mobilefinalprojectfinal.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var crepo:FoodsRepository) : ViewModel() {

    fun addToCartFromDetail(id: Int,ad:String,resim:String,fiyat:Int,kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.addToCartFromDetail(id,ad,resim,fiyat,kullanici_adi)
        }

    }

}