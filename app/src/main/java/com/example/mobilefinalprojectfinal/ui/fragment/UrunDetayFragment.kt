package com.example.mobilefinalprojectfinal.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.mobilefinalprojectfinal.R
import com.example.mobilefinalprojectfinal.databinding.FragmentSepetBinding
import com.example.mobilefinalprojectfinal.databinding.FragmentUrunDetayBinding

class UrunDetayFragment : Fragment() {

    private lateinit var binding: FragmentUrunDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = FragmentUrunDetayBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_urun_detay,container,false)

        binding.urunDetayToolbarBaslik = "Urun Detay"

        val bundle:UrunDetayFragmentArgs by navArgs()
        val detayGelenFood = bundle.food

        //HomeAdapter'dan gelen bilgilerin DetayFragmentta gösterilmesi
        binding.imageViewUrunDetay.setImageResource(resources.getIdentifier(detayGelenFood.resim,"drawable",requireContext().packageName))
        binding.textViewDetayAd.text=detayGelenFood.ad
        binding.textViewDetayFiyat.text=detayGelenFood.fiyat

        binding.toolbarUrunDetay.title=detayGelenFood.ad

        //Burada loga yazacağım
        binding.buttonSepeteEkle.setOnClickListener {
            val food_ad = binding.textViewDetayAd.text.toString()
            val food_price = binding.textViewDetayFiyat.text.toString()

            kaydet(food_ad,food_price)

        }

        return binding.root
    }

    fun butonToSepet(it:View){
        Navigation.findNavController(it).navigate(R.id.homeToSepet)
    }

    fun kaydet(food_ad:String,food_price:String) {

        Log.e("Food Kaydet", "$food_ad - $food_price")

    }

}