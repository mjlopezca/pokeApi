package com.bankaya.pokeApiTest.mapper;

import org.springframework.stereotype.Component;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.testmanuel.AbilitiesResponse;
import com.testmanuel.ArrayAbilitiesResponse;
import com.testmanuel.ArrayHeldItemResponse;
import com.testmanuel.HeldItemResponse;
import com.testmanuel.ObjectFactory;
import com.testmanuel.PokemonResponse;
/**
 * class to converter model wsdl to model poke api or upside down
 * @author dakze
 *
 */
@Component

public class PokemonMapper  {
	
	public PokemonResponse toOuter(Pokemon poke) {
		ObjectFactory factory = new ObjectFactory();
		PokemonResponse response = factory.createPokemonResponse();
		response.setBaseExperience(poke.getBaseExperience());
		response.setId(poke.getId());
		response.setName(poke.getName());
		response.setAbilities(new ArrayAbilitiesResponse());
		poke.getAbilities().forEach((p)->{
			AbilitiesResponse abi=new AbilitiesResponse();
			abi.setName(p.getAbility().getName());
			response.getAbilities().getAbilitie().add(abi);
		});
		response.setLocalAreaEnconters(poke.getLocationAreaEncounters());
		response.setHeldItems(new ArrayHeldItemResponse());
		poke.getHeldItems().forEach((h)->{
			HeldItemResponse heldI=new HeldItemResponse();
			heldI.setName(h.getItem().getName());
			response.getHeldItems().getHeldItems().add(heldI);
		});
		return response;
    }



}
