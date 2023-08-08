package com.example.mobilefinalprojectfinal.ui.adapter

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobilefinalprojectfinal.R
import com.example.mobilefinalprojectfinal.data.entity.SepetFoods
import com.example.mobilefinalprojectfinal.databinding.CardTasarimSepetBinding
import com.example.mobilefinalprojectfinal.ui.viewmodel.SepetViewModel
import com.example.mobilefinalprojectfinal.utility.UserNameStatic
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(var mContext: Context, var foodListesi:List<SepetFoods>, var viewModel: SepetViewModel)
    : RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu>() {

    inner class SepetCardTasarimTutucu(var tasarimSepet:CardTasarimSepetBinding) : RecyclerView.ViewHolder(tasarimSepet.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val binding : CardTasarimSepetBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_tasarim_sepet,parent,false)
        return SepetCardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val foodSepet = foodListesi.get(position)
        val t2 = holder.tasarimSepet
        t2.foodVariableSepet = foodSepet

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${foodSepet.adi}"
        getImageFromGlide(url,t2.imageViewSepetFood)

        t2.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${foodSepet.adi} discard?",Snackbar.LENGTH_SHORT)
                .setAction("Yes"){
                    deleteFood(foodSepet.sepet_id, kullanici_adi = UserNameStatic.user_name)
                }.show()
        }

        /*t2.imageViewSepetFood.setImageResource(
            mContext.resources.getIdentifier(foodSepet.resim,"drawable",mContext.packageName)
        )

        t2.textViewSepetName.text = foodSepet.ad
        t2.textViewSepetPrice.text = "${foodSepet.fiyat} ₺"

        t2.imageViewSepetFood.setImageResource(
            mContext.resources.getIdentifier(foodSepet.resim,"drawable",mContext.packageName)
        )

        t2.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${foodSepet.ad} silmek istediğinize emin misiniz?",Snackbar.LENGTH_SHORT).setAction("EVET"){
                sil(foodSepet.id)
            }.show()
        }*/

    }
    /*fun sil(id:Int){
        Log.e("Food Sil", id.toString())

    }*/

    fun getImageFromGlide(url: String, imageViewSepetFoods: ImageView) {
        Glide.with(mContext).load(url).override(300,300).into(imageViewSepetFoods)
    }

    override fun getItemCount(): Int {
        return foodListesi.size

    }

    fun deleteFood(yemek_id: Int,kullanici_adi:String){
        viewModel.deleteFood(yemek_id,kullanici_adi)
    }


}