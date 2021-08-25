package com.bankaya.pokeApiTest.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaya.pokeApiTest.mapper.PokemonMapper;
import com.bankaya.pokeApiTest.service.PokemonService;
import com.bankaya.pokeApiTest.service.TransformWsService;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.testmanuel.PokemonResponse;


@Service
public class TransformWsServiceImpl implements TransformWsService{
	
	@Autowired
	PokemonService pokemonService;
	
	@Autowired
	PokemonMapper pokemonMapper;

	@Override
	public PokemonResponse getPokemon(String name) {
		Pokemon poke= pokemonService.getPokemon(name);
		return pokemonMapper.toOuter(poke);
		
	}

	

}
