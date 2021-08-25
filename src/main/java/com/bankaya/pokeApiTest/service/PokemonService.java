package com.bankaya.pokeApiTest.service;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;

public interface PokemonService {
    public Pokemon getPokemon(String name);
}