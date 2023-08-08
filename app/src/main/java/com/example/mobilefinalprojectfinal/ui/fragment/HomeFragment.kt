package com.example.mobilefinalprojectfinal.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mobilefinalprojectfinal.R
import com.example.mobilefinalprojectfinal.data.entity.Foods
import com.example.mobilefinalprojectfinal.databinding.ActivityMainBinding
import com.example.mobilefinalprojectfinal.databinding.FragmentHomeBinding
import com.example.mobilefinalprojectfinal.ui.adapter.HomeAdapter


class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.title  ="Menu"

        binding.rvHome.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val HomeFoodListesi = ArrayList<Foods>()
        val f1 = Foods(1,"Ayran","ayran","15")
        val f2 = Foods(2,"Kola","cola","30")
        val f3 = Foods(3,"Fanta","fanta","30")
        val f4 = Foods(4,"Hamburger","hamburger","150")
        val f5 = Foods(5,"Indian","indian","250")
        val f6 = Foods(6,"Kebap","kebap","250")
        val f7 = Foods(7,"Makarna","makarna","125")
        val f8 = Foods(8,"Margarita","margarita","180")
        val f9 = Foods(9,"Patates Kızartması","patates","50")
        val f10 = Foods(10,"Pizza","pizza","250")

        HomeFoodListesi.add(f1)
        HomeFoodListesi.add(f2)
        HomeFoodListesi.add(f3)
        HomeFoodListesi.add(f4)
        HomeFoodListesi.add(f5)
        HomeFoodListesi.add(f6)
        HomeFoodListesi.add(f7)
        HomeFoodListesi.add(f8)
        HomeFoodListesi.add(f9)
        HomeFoodListesi.add(f10)

        val adapterHome = HomeAdapter(requireContext(),HomeFoodListesi)
        binding.rvHome.adapter = adapterHome


        //Toolbarda arama özelliğini aktive ediyorum
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item =menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        //binding.buttonHomeSepeteGit.setOnClickListener {
        //    Navigation.findNavController().navigate(R.id.homeToSepet)
        //}


        return binding.root
    }

    //Search bar ile birlikte implemente edilen fonksiyonlar
    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
        Log.e("Food Ara",aramaKelimesi)

    }

}