package com.cz.czbazzar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cz.czbazzar.Adaptar.modelAdapta
import com.cz.czbazzar.databinding.ActivityMain2Binding

import com.cz.czbazzar.model_class.Adproductmodel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getProductstoP(intent.getStringExtra("productName"))
    }
    private fun getProductstoP(catp: String?) {
        

        val list = ArrayList<Adproductmodel>()
        Firebase.firestore.collection("products").whereEqualTo("productName", catp)
            .get().addOnSuccessListener {

                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(Adproductmodel::class.java)
                    list.add(data!!)
                }


                binding.re2.adapter = modelAdapta(this, list)
            }


    }
}