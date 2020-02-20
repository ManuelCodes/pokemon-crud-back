package com.pokemon.pokemoncrud.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "petit_cup_rules")
public class PetitCupRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "id_pokemon")
    private Integer idPokemon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }
}
