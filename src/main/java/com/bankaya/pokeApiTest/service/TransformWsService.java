package com.bankaya.pokeApiTest.service;

import com.testmanuel.PokemonResponse;

public interface TransformWsService {
    public PokemonResponse getPokemon(String name);
}