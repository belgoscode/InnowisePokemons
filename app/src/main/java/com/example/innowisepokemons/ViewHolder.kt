package com.example.innowisepokemons

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.choice_image)
    val textView: TextView = itemView.findViewById(R.id.choice_name)
    fun bind(pokemon: Pokemon, onClick: (Int) -> Unit) {
        imageView.setImageResource(pokemon.picture ?: R.drawable.errorpicture)
        textView.text = pokemon.name ?: "Unknown"
        itemView.setOnClickListener {
            val id = pokemon.id ?: run {
                Toast.makeText(
                    itemView.context,
                    "Oops! Error opening this pokemon.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            onClick(id)
        }
    }
}