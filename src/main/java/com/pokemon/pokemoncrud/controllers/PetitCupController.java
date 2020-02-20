package com.pokemon.pokemoncrud.controllers;

import com.pokemon.pokemoncrud.DTOs.PokemonDTO;
import com.pokemon.pokemoncrud.applications.PetitCupApplication;
import com.pokemon.pokemoncrud.entities.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/petit-cup")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PetitCupController {

    @Autowired
    PetitCupApplication petitCupApplication;


    @PostMapping("add-pokemon")
    private void addPokemon(@RequestBody PokemonDTO PokemonDTO) throws Exception {
        petitCupApplication.addPokemon(PokemonDTO);
    }

    @GetMapping("pokemon/{id}")
    private Pokemon findById(@PathVariable("id") Integer id) throws Exception {
        return petitCupApplication.findByIdPokemon(id);
    }
}
