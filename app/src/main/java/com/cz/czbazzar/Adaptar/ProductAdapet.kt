package com.cz.czbazzar.Adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cz.czbazzar.MainActivity2
import com.cz.czbazzar.MainActivity3
import com.cz.czbazzar.databinding.ItemProduct1Binding
import com.cz.czbazzar.model_class.Adproductmodel


class productAdapet(val context: Context, val list: ArrayList<Adproductmodel>)
    :RecyclerView.Adapter<productAdapet.productViewHolder>(){

    inner class productViewHolder(val binding: ItemProduct1Binding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewHolder {
        val binding=ItemProduct1Binding.inflate(LayoutInflater.from(context),parent,false)
        return productViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: productViewHolder, position: Int) {
       val data=list[position]
        Glide.with(context).load(data.productCoverImage).into(holder.binding.imageView)
        holder.binding.textView.text=data.productName
        holder.binding.textView2.text=data.productCatagory
        holder.binding.textView3.text=data.productMrp
        holder.itemView.setOnClickListener {
            val intent=Intent(context, MainActivity2::class.java)
            intent.putExtra("productName",list[position].productName)
            context.startActivity(intent)
        }

    }
}
