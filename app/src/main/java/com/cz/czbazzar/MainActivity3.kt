package com.cz.czbazzar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cz.czbazzar.Adaptar.modelAdapta
import com.cz.czbazzar.databinding.ActivityMain3Binding
import com.cz.czbazzar.model_class.Adproductmodel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        getProducts(intent.getStringExtra("catagory"))

        setContentView(binding.root)
    }

    private fun getProducts(cat: String?) {

        val list = ArrayList<Adproductmodel>()
        Firebase.firestore.collection("products").whereEqualTo("productCatagory", cat)
            .get().addOnSuccessListener {

                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(Adproductmodel::class.java)
                    list.add(data!!)
                }


                binding.re.adapter = modelAdapta(this, list)
            }
    }


}