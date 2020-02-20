package com.pokemon.pokemoncrud.repositories;

import com.pokemon.pokemoncrud.entities.PetitCupRule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetitCupRuleRepository extends CrudRepository<PetitCupRule,Integer> {

    PetitCupRule findByIdPokemon(Integer idPokemon);
}
