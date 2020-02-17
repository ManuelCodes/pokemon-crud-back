package com.pokemon.pokemoncrud.repositories;

import com.pokemon.pokemoncrud.entities.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
}
