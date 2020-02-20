package com.pokemon.pokemoncrud.controllers;

import com.pokemon.pokemoncrud.DTOs.PokemonDTO;
import com.pokemon.pokemoncrud.applications.PokemonApplication;
import com.pokemon.pokemoncrud.entities.Pokemon;
import com.pokemon.pokemoncrud.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/national-pokedex")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class NationalPokedexController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonApplication pokemonApplication;

    @GetMapping("pokemon/{id}")
    private Optional<Pokemon> findById(@PathVariable("id") Integer id) {
        return pokemonApplication.findById(id);
    }

    @GetMapping("pokemons")
    private Iterable<Pokemon> findAll() {
        return pokemonApplication.findAll();
    }

    @PostMapping("add-pokemon")
    private void addPokemon(@RequestBody PokemonDTO PokemonDTO) throws Exception {
        pokemonApplication.addPokemon(PokemonDTO);
    }

    @PostMapping("update-pokemon")
    private void updatePokemon(@RequestBody PokemonDTO pokemonDTO) throws Exception {
        pokemonApplication.updatePokemon(pokemonDTO);
    }
}
