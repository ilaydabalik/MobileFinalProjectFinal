package com.example.mobilefinalprojectfinal.data.datasource

import android.util.Log
import com.example.mobilefinalprojectfinal.data.entity.SepetFoods
import com.example.mobilefinalprojectfinal.retrofit.CartFoodsDao
import com.example.mobilefinalprojectfinal.utility.UserNameStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SepetFoodsDataSource(var cdao: CartFoodsDao) {

    suspend fun addToCartFromDetail(yemek_id: Int,yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,
                                    yemek_siparis_adet:Int,kullanici_adi:String){
        val checkCartList = loadFoodsToCart() ?: emptyList()
        var checkFlag = false
        var checkedFoodQuantity = 0
        var checkedCartId = 0

        if(checkFlag){
            deleteFood(checkedCartId, UserNameStatic.user_name)
            val newQuantity = yemek_siparis_adet + checkedFoodQuantity
            cdao.addToCartFromDetail(yemek_adi,yemek_resim_adi,yemek_fiyat)
        }else{

        }
    }

    suspend fun deleteFood(yemek_id: Int,kullanici_adi: String){
        cdao.deleteFoods(yemek_id,kullanici_adi)
    }

    suspend fun increaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id increased----$quantity")
    }

    suspend fun decreaseQuantity(yemek_id: Int,quantity : Int){
        Log.e("quantity","$yemek_id decreased----$quantity")
    }

    suspend fun loadFoodsToCart(): List<SepetFoods> {
        return try {
            withContext(Dispatchers.IO) {
                cdao.loadCartFoods(UserNameStatic.user_name).sepet_yemekler
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }


}