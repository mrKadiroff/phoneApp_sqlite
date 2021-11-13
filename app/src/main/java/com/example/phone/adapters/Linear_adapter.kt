package com.example.phone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.R
import com.example.phone.databinding.LinearItemBinding
import com.example.phone.interfaces.OnCliclinear

class Linear_adapter( var list : Array<String>, var clickListener: OnCliclinear) : RecyclerView.Adapter<Linear_adapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var binding = LinearItemBinding.bind(view)

        fun onBind(model : String){
            binding.textView.text = model
            binding.root.setOnClickListener {
                clickListener.onClicItem(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.linear_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}