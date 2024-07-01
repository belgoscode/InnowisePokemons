package com.example.innowisepokemons

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisepokemons.databinding.ActivityMainBinding
import com.example.innowisepokemons.databinding.PokemonChoiceBinding

class ViewHolder(private val binding: PokemonChoiceBinding) : RecyclerView.ViewHolder(binding.root) {
    val imageView: ImageView = binding.choiceImage
    val textView: TextView = binding.choiceName
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