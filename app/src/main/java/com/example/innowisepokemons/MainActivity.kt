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
        val adapter = ChoiceAdapter(PokemonList.pokemons.filterNotNull()) { pokemonId ->
            startPokemonDetailActivity(pokemonId)
        }
        binding.pokemonList.adapter = adapter
        binding.pokemonList.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                (binding.pokemonList.layoutManager as LinearLayoutManager).orientation
            )
        )
        adapter.updateAdapter(PokemonList.pokemons.filterNotNull())
    }

    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, DetailedInfoActivity::class.java)
        intent.putExtra("pokemon_id", pokemonId - 1)
        startActivity(intent)
    }
}