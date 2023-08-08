package com.example.mobilefinalprojectfinal.ui.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobilefinalprojectfinal.data.entity.SepetFoods
import com.example.mobilefinalprojectfinal.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class SepetViewModel @Inject constructor(var crepo:FoodsRepository) : ViewModel(){

    var sepetFoodList = MutableLiveData<List<SepetFoods>?>()

    init {
        loadFoodsToSepet()
    }

    fun loadFoodsToSepet(){
        CoroutineScope(Dispatchers.Main).launch {
            sepetFoodList.value = crepo.loadFoodsToSepet()
        }
    }

    fun deleteFood(id: Int, kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.deleteFood(id, kullanici_adi)

            val newList = sepetFoodList.value?.toMutableList()
            newList?.removeAll { it.sepet_id == id }
            sepetFoodList.value = newList
        }
    }



}


    fun deleteFood(id: Int, kullaniciAdi: String) {

    }


