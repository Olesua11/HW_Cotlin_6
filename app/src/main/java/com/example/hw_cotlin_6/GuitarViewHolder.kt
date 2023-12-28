package com.example.hw_cotlin_6

import GuitarModel
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GuitarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.guitarNameTextView)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.guitarDescriptionTextView)
    val imageView: ImageView = itemView.findViewById(R.id.img_pin)


    fun bind(guitar: GuitarModel) {
        nameTextView.text = guitar.name
        descriptionTextView.text = guitar.description

        Glide.with(itemView)
            .load(guitar.imageUrl)
            .into(imageView)
    }
}
