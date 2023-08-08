package com.example.mobilefinalprojectfinal.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilefinalprojectfinal.R
import com.example.mobilefinalprojectfinal.data.entity.Foods
import com.example.mobilefinalprojectfinal.databinding.FragmentHomeBinding
import com.example.mobilefinalprojectfinal.databinding.FragmentSepetBinding
import com.example.mobilefinalprojectfinal.ui.adapter.HomeAdapter


class SepetFragment : Fragment() {

    private lateinit var binding: FragmentSepetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        binding.toolbarSepet.title="Sepet"

        binding.rvSepet.layoutManager = LinearLayoutManager(requireContext())

        //Burada Normalde aşağıdaki liste değil detay sayfasında ekle butonuna tıklandığında gelen nesneler gözükecek
        val SepetFoodListesi = ArrayList<Foods>()
        val sf1 = Foods(1,"Hamburger","hamburger","150")
        val sf2 = Foods(2,"Kola","colaa","30")

        SepetFoodListesi.add(sf1)
        SepetFoodListesi.add(sf2)

        val adapterSepet = HomeAdapter(requireContext(),SepetFoodListesi)
        binding.rvSepet.adapter = adapterSepet



        //Sayfa geçişi yapabilmemiz için - sayfaya gönderilen ne varsa iletecek olan alt yapı
        val bundle:SepetFragmentArgs by navArgs()
        val gelenGelenAd = bundle.foodSepete

        //binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        //binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        //Guncelleme butonu işlemlerini de burada yapamadım

        //Sepeti Onayla
        binding.buttonOnayla.setOnClickListener {

            //Burada card tasarımından gelen val isim ve fiyat bilgileri alınması lazım

        }

        return binding.root
    }

    fun butonTıkla(){
        //Burada DB'ye yazdırma işlemini yapacağız
        //Navigation.findNavController(it).navigate(R.id.)
    }

    fun onayla(food_ad:String,food_price:String){

        Log.e("Sepeti Onayla","$food_ad-$food_price")

    }

}