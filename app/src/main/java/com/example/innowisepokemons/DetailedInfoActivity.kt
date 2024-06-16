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

    private lateinit var nameTextView: TextView
    private lateinit var pictureImageView: ImageView
    private lateinit var typeTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var heightTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val pokemonId = intent.getIntExtra("pokemon_id", -1)
        val pokemon = PokemonList.getPokemonById(pokemonId)

        nameTextView = findViewById(R.id.pokemon_name)
        pictureImageView = findViewById(R.id.pokemon_picture)
        typeTextView = findViewById(R.id.pokemon_type)
        weightTextView = findViewById(R.id.pokemon_weight)
        heightTextView = findViewById(R.id.pokemon_height)


        nameTextView.text = pokemon?.name
        pictureImageView.setImageResource(pokemon?.picture ?: 0)
        typeTextView.text = pokemon?.type
        weightTextView.text = "Weight: ${pokemon?.weight} kg"
        heightTextView.text = "Height: ${pokemon?.height} m"
    }
}