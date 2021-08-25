package com.bankaya.pokeApiTest.service.impl;

import org.springframework.stereotype.Service;
import com.bankaya.pokeApiTest.service.PokemonService;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;

@Service
public class PokemonServiceImpl implements PokemonService{

	@Override
	/**api consult pokenmon api
	 * getPokemon by name
	 */
	public Pokemon getPokemon(String name) {
		Client.CACHE = false;
		Pokemon poke = Pokemon.getByName(name);
		return poke;
	}
    
}