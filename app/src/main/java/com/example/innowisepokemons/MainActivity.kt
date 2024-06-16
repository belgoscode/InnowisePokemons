package com.example.innowisepokemons
import com.example.innowisepokemons.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.innowisepokemons.PokemonList.pokemons

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonNames = PokemonList.pokemons.values.map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pokemonNames)

        binding.pokemonList.adapter = adapter
        binding.pokemonList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val pokemon = PokemonList.pokemons[position+1]
            if (pokemon != null) {
                startPokemonDetailActivity(pokemon.id)
            } else {
                Toast.makeText(this, "Error: cant access this pokemon!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, DetailedInfoActivity::class.java)
        intent.putExtra("pokemon_id", pokemonId)
        startActivity(intent)
    }
}