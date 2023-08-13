package com.cz.czbazzar.Adaptar


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cz.czbazzar.MainActivity3
import com.cz.czbazzar.R
import com.cz.czbazzar.databinding.CatagoryItemBinding
import com.cz.czbazzar.model_class.catdata

class catagoryAdapter(var context: Context, var list: ArrayList<catdata>)
    :RecyclerView.Adapter<catagoryAdapter.catagoryViewHolder>() {
    inner class catagoryViewHolder(view:View):RecyclerView.ViewHolder(view){

        var binding =CatagoryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catagoryViewHolder {
        return catagoryViewHolder(LayoutInflater.from(context).inflate(R.layout.catagory_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: catagoryViewHolder, position: Int) {

        holder.binding.catPText.text=list[position].productCatagory

        Glide.with(context).load(list[position].productCoverImage).into(holder.binding.catPImg)
        holder.itemView.setOnClickListener {
            val intent=Intent(context, MainActivity3::class.java)
            intent.putExtra("catagory",list[position].productCatagory)
            context.startActivity(intent)
        }


    }
}