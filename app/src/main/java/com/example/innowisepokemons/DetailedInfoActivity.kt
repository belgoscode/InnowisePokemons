package com.example.innowisepokemons

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.innowisepokemons.databinding.ActivityDetailedInfoBinding

class DetailedInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val pokemonId = intent.getIntExtra("pokemon_id", -1)
        val pokemon = PokemonList.getPokemonById(pokemonId)
        
        binding.pokemonName.text = pokemon?.name ?: "Unknown pokemon"
        binding.pokemonPicture.setImageResource(pokemon?.picture ?: R.drawable.errorpicture)
        binding.pokemonType.text = pokemon?.type ?: "Unknown type"
        binding.pokemonWeight.text = "Weight: ${pokemon?.weight ?: 4.04} kg"
        binding.pokemonHeight.text = "Height: ${pokemon?.height ?: 4.04} m"
    }
}