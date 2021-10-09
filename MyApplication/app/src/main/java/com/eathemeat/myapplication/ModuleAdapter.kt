package com.eathemeat.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eathemeat.module.ModuleItem
import com.eathemeat.module.ModuleManager
import com.eathemeat.myapplication.databinding.ItemTestBinding

class ModuleAdapter : RecyclerView.Adapter<ModuleAdapter.ModeluViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeluViewholder {
        var binding = ItemTestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ModeluViewholder(binding,binding.root)
    }

    override fun onBindViewHolder(holder: ModeluViewholder, position: Int) {
        var item = ModuleManager.get(position)
        holder.update(item)

    }

    override fun getItemCount(): Int {
        return ModuleManager.size()
    }




    class ModeluViewholder(val binding: ItemTestBinding,var itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun update(item: ModuleItem): Unit {
            binding.tvModuleTitle.text = item.getTitle()
        }

    }
}