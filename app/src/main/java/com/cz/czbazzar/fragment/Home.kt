package com.cz.czbazzar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide

import com.cz.czbazzar.Adaptar.catagoryAdapter
import com.cz.czbazzar.databinding.FragmentHomeBinding
import com.cz.czbazzar.Adaptar.productAdapet
import com.cz.czbazzar.model_class.Adproductmodel
import com.cz.czbazzar.model_class.catdata
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class home : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater)

        getCatagory()
        getProducts()
        getSlider()


        return binding.root
    }

    private fun getSlider() {
        Firebase.firestore.collection("slider").document("item").get()
            .addOnSuccessListener {
            Glide.with(requireContext()).load(it.get("image")).into(binding.sliderImgView)
        }
    }

    private fun getProducts() {

        val list =ArrayList<Adproductmodel>()
        Firebase.firestore.collection("products")
            .get().addOnSuccessListener {

                list.clear()
                for (doc in it.documents){
                    val data=doc.toObject(Adproductmodel::class.java)
                    list.add(data!!)
                }


               binding.productRecycler.adapter= productAdapet(requireContext(), list)
            }

    }


    private fun getCatagory() {

        val list =ArrayList<catdata>()
        Firebase.firestore.collection("catagory")
            .get().addOnSuccessListener {

                list.clear()
                for (doc in it.documents){
                    val data=doc.toObject(catdata::class.java)
                    list.add(data!!)
                }

                binding.catagoryRecycler.adapter= catagoryAdapter(requireContext(), list)
            }

    }


}