package com.example.innowisepokemons

import com.example.innowisepokemons.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
        val adapter = ChoiceAdapter(PokemonList.pokemons) { pokemonId ->
            startPokemonDetailActivity(pokemonId)
        }
        binding.pokemonList.adapter = adapter
        binding.pokemonList.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                (binding.pokemonList.layoutManager as LinearLayoutManager).orientation
            )
        )
        adapter.updateAdapter(PokemonList.pokemons)
    }

    class ChoiceAdapter(
        private var choiceList: Map<Int, Pokemon?>,
        private val onClick: (Int) -> Unit
    ) : RecyclerView.Adapter<ChoiceAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val choiceView = LayoutInflater.from(parent.context)
                .inflate(R.layout.pokemon_choice, parent, false)
            return ViewHolder(choiceView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentView = choiceList[position]
            holder.imageView.setImageResource(currentView?.picture ?: R.drawable.errorpicture)
            holder.textView.text = currentView?.name ?: "Unknown pokemon"
            holder.itemView.setOnClickListener {
                val id = currentView?.id ?: run {
                    Toast.makeText(
                        holder.itemView.context,
                        "Oops! Error opening this pokemon.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                onClick(id)
            }
        }

        fun updateAdapter(newChoiceList: Map<Int, Pokemon?>) {
            val diffUtilCallback = ChoiceDiffUtilCallback(choiceList, newChoiceList)
            choiceList = newChoiceList
            DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)        }

        override fun getItemCount(): Int {
            return choiceList.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.choice_image)
            val textView: TextView = itemView.findViewById(R.id.choice_name)
        }
    }

    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, DetailedInfoActivity::class.java)
        intent.putExtra("pokemon_id", pokemonId)
        startActivity(intent)
    }
}