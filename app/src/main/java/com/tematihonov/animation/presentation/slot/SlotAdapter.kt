package com.tematihonov.animation.presentation.slot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tematihonov.animation.R
import com.tematihonov.animation.databinding.RecyclerviewItemBinding

class SlotAdapter(private val list: List<Int>) :
    RecyclerView.Adapter<SlotAdapter.SlotViewHolder>() {

    val iconList = listOf(
        R.drawable.fortune_wheel
//        R.drawable.symbols01,
//        R.drawable.symbols02,
//        R.drawable.symbols03,
//        R.drawable.symbols04,
//        R.drawable.symbols05,
//        R.drawable.symbols06,
//        R.drawable.symbols07,
//        R.drawable.symbols08,
//        R.drawable.symbols09,
    )

    class SlotViewHolder(
        val binding: RecyclerviewItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemBinding.inflate(inflater, parent, false)
        return SlotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlotViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            symbol.setImageResource(iconList.get(list.get(position)))
        }
    }

    override fun getItemCount(): Int = list.size
}