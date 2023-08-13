package com.cz.czbazzar.Adaptar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cz.czbazzar.R
import com.cz.czbazzar.databinding.ItemProduct2Binding
import com.cz.czbazzar.databinding.ModelBinding
import com.cz.czbazzar.model_class.Adproductmodel

class modelAdapta2(var context: Context, var list: ArrayList<Adproductmodel>)
    : RecyclerView.Adapter<modelAdapta2.modelViewHolder>() {
    inner class modelViewHolder(view: View):RecyclerView.ViewHolder(view){

        val binding=ItemProduct2Binding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): modelViewHolder {
        return modelViewHolder(LayoutInflater.from(context).inflate(R.layout.model,parent,false))


    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: modelViewHolder, position: Int) {
        holder.binding.name2.text=list[position].productName

        Glide.with(context).load(list[position].productCoverImage).into(holder.binding.pic2)

    }
}