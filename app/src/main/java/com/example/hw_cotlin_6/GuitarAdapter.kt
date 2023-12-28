package com.example.hw_cotlin_6

import GuitarModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw_cotlin_6.R

class GuitarAdapter(
    private val guitars: List<GuitarModel>,
    private val onGuitarClickListener: (GuitarModel) -> Unit
) : RecyclerView.Adapter<GuitarAdapter.GuitarViewHolder>() {

    class GuitarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.guitarNameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.guitarDescriptionTextView)
        val imageView: ImageView = itemView.findViewById(R.id.img_pin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_guitar, parent, false)
        return GuitarViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuitarViewHolder, position: Int) {
        val guitar = guitars[position]
        holder.nameTextView.text = guitar.name
        holder.descriptionTextView.text = guitar.description

        Glide.with(holder.itemView)
            .load(guitar.imageUrl)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            onGuitarClickListener.invoke(guitar)
        }
    }

    override fun getItemCount(): Int {
        return guitars.size
    }
}
