package com.example.innowisepokemons

object PokemonList {
    val pokemons: List<Pokemon> = listOf(
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            picture = R.drawable.bulbasaur,
            type = "Grass, Poison",
            height = 0.7,
            weight = 6.9
        ),
        Pokemon(
            id = 2,
            name = "Ivysaur",
            picture = R.drawable.ivysaur,
            type = "Grass, Poison",
            height = 1.0,
            weight = 13.0
        ),
        Pokemon(
            id = 3,
            name = "Charmander",
            picture = R.drawable.charmander,
            type = "Fire",
            height = 0.6,
            weight = 8.5
        ),
        Pokemon(
            id = 4,
            name = "Squirtle",
            picture = R.drawable.squirtle,
            type = "Water",
            height = 0.5,
            weight = 9.0
        ),
        // Сюда хардкодить покемонов
    )

    fun getPokemonById(id: Int): Pokemon? {
        return pokemons.find { it.id == id }
    }
}