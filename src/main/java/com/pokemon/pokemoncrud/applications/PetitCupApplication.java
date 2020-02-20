package com.pokemon.pokemoncrud.applications;

import com.pokemon.pokemoncrud.DTOs.PokemonDTO;
import com.pokemon.pokemoncrud.entities.Level25FirstGenerationPetitCup;
import com.pokemon.pokemoncrud.entities.PetitCupRule;
import com.pokemon.pokemoncrud.entities.Pokemon;
import com.pokemon.pokemoncrud.repositories.Level25FirstGenerationPetitCupRepository;
import com.pokemon.pokemoncrud.repositories.PetitCupRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetitCupApplication {

    @Autowired
    private PetitCupRuleRepository petitCupRuleRepository;

    @Autowired
    private Level25FirstGenerationPetitCupRepository level25FirstGenerationPetitCupRepository;

    @Autowired PokemonApplication pokemonApplication;

    public void addPokemon(PokemonDTO pokemonDTO) throws  Exception {

        Pokemon pokemon = pokemonApplication.findById(pokemonDTO.getId()).get();
        if(pokemon == null) {
            throw new Exception("El pokemon no existe");
        }
        PetitCupRule petitCupRule = petitCupRuleRepository.findByIdPokemon(pokemon.getId());
        if(petitCupRule == null) {
            throw new Exception("Este pokemon no cumple con las reglas para este torneo");
        }

        Level25FirstGenerationPetitCup level25FirstGenerationPetitCup = new Level25FirstGenerationPetitCup();
        level25FirstGenerationPetitCup.setId_rule(petitCupRule.getId());
        level25FirstGenerationPetitCup.setActive(1);
        level25FirstGenerationPetitCupRepository.save(level25FirstGenerationPetitCup);
    }

    public Pokemon findByIdPokemon(Integer id) throws Exception {
        Pokemon pokemon = pokemonApplication.findById(id).get();
        if(pokemon == null) {
            throw new Exception("El pokemon no existe");
        }
        PetitCupRule petitCupRule = petitCupRuleRepository.findByIdPokemon(pokemon.getId());
        if(petitCupRule == null) {
            throw new Exception("Este pokemon no cumple con las reglas para este torneo");
        }
        return pokemon;


    }

}
