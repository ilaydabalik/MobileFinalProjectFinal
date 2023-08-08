package com.example.mobilefinalprojectfinal.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobilefinalprojectfinal.R
import com.example.mobilefinalprojectfinal.data.entity.Foods
import com.example.mobilefinalprojectfinal.databinding.CardTasarimHomeBinding
import com.example.mobilefinalprojectfinal.databinding.CardTasarimSepetBinding
import com.example.mobilefinalprojectfinal.databinding.FragmentHomeBinding
import com.example.mobilefinalprojectfinal.ui.fragment.HomeFragmentDirections
import com.example.mobilefinalprojectfinal.ui.viewmodel.HomeViewModel

class HomeAdapter(var mContext:Context, var foodListesi:List<Foods>, var viewModel: HomeViewModel)
    : RecyclerView.Adapter<HomeAdapter.HomeCardTasarimTutucu>(){

    inner class HomeCardTasarimTutucu(var tasarimHome: CardTasarimHomeBinding) : RecyclerView.ViewHolder(tasarimHome.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardTasarimTutucu {
       val binding : CardTasarimHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
           R.layout.card_tasarim_home,parent,false)
        return HomeCardTasarimTutucu(binding)

    }

    override fun onBindViewHolder(holder: HomeCardTasarimTutucu, position: Int) {
        val foodHome = foodListesi.get(position)
        val t = holder.tasarimHome
        t.foodVariableMain = foodHome

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${foodHome.ad}"
        Glide.with(mContext).load(url).override(300,300).into(t.imageViewHomeFood)

        /*t.textViewHomeName.text = foodHome.ad
        t.textViewHomePrice.text = "${foodHome.fiyat} ₺"
        t.imageViewHomeFood.setImageResource(
            mContext.resources.getIdentifier(foodHome.resim,"drawable",mContext.packageName)
        )

        t.cardViewHome.setOnClickListener {
            val gecisDetay = HomeFragmentDirections.urunDetayGecis(food = foodHome)
            Navigation.findNavController(it).navigate(gecisDetay)
        }*/

    }
    fun getImageFromGlide(url: String, imageViewHomeFoods: ImageView) {
        Glide.with(mContext).load(url).override(300,300).into(imageViewHomeFoods)
    }

    override fun getItemCount(): Int {
        return foodListesi.size
    }

}