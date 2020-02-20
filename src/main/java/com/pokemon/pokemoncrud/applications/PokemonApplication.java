package com.pokemon.pokemoncrud.applications;

import com.pokemon.pokemoncrud.DTOs.PokemonDTO;
import com.pokemon.pokemoncrud.entities.Pokemon;
import com.pokemon.pokemoncrud.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonApplication {
    @Autowired
    private PokemonRepository pokemonRepository;

    private final Integer DEFAULT_ID = 1;

    public Iterable<Pokemon>  findAll() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> findById(Integer id) {
        return pokemonRepository.findById(id);
    }

    public void addPokemon(PokemonDTO pokemonDTO) throws  Exception {
        if(pokemonDTO == null) {
            throw new Exception("error");
        }
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setUser_id(DEFAULT_ID);

        pokemonRepository.save(pokemon);
    }

    public void updatePokemon(PokemonDTO pokemonDTO) throws  Exception {
        if(pokemonDTO == null) {
            throw new Exception("error");
        }
        Pokemon pokemon = pokemonRepository.findById(pokemonDTO.getId()).get();
        pokemon.setName(pokemonDTO.getName());

        pokemonRepository.save(pokemon);
    }
}
