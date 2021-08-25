package com.bankaya.pokeApiTest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.bankaya.pokeApiTest.service.TransformWsService;
import com.testmanuel.PokemonRequest;
import com.testmanuel.PokemonResponse;

@Endpoint
public class WebServiceEndpoint {
	
	@Autowired
	TransformWsService transformService;

	private static final String NAMESPACE_URI = "http://testmanuel.com";

	/**
	 * endpoint only name pokemon
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonRequest")
	@ResponsePayload
	public PokemonResponse searchPokemon(@RequestPayload PokemonRequest request) {
		
		return transformService.getPokemon(request.getName());
	}
}
