package com.example.innowisepokemons

object PokemonList {
    val pokemons: List<Pokemon> = listOf(
        Pokemon(
            id = 1,
            name = "First",
            picture = R.drawable.bulbasaur,
            type = "First type",
            height = 0.0,
            weight = 0.0
        ),
        Pokemon(
            id = 2,
            name = "Second",
            picture = R.drawable.bulbasaur,
            type = "Second type",
            height = 0.0,
            weight = 0.0
        ),

        // Сюда хардкодить покемонов
    )

    fun getPokemonById(id: Int): Pokemon? {
        return pokemons.find { it.id == id }
    }
}