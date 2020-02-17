package com.pokemon.pokemoncrud.controllers;

import com.pokemon.pokemoncrud.entities.Pokemon;
import com.pokemon.pokemoncrud.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("test")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TestController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("pokemon/{id}")
    private Optional<Pokemon> findById(@PathVariable("id") Integer id) {
        return pokemonRepository.findById(id);
    }

    @GetMapping("pokemons")
    private Iterable<Pokemon>  findAll() {
        return pokemonRepository.findAll();
    }
}
