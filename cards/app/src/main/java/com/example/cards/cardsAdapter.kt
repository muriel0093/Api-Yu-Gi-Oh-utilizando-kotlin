package com.example.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.cards.model.Cartas

class cardsAdapter(private val cards: List<Cartas>) : RecyclerView.Adapter<cardsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindView(item: Cartas) =
            with(itemView){
                val ivCard = findViewById<ImageView>(R.id.ivCard)

                item?.let {
                    Glide.with(itemView.context).load(it.imageUrl).into(ivCard)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: cardsAdapter.ViewHolder, position: Int) {
        val Cards = cards[position]

        holder.bindView(Cards)
    }

    override fun getItemCount() = cards.size
}