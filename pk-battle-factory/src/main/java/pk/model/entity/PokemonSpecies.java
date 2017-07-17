package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "pokemon_species")
public class PokemonSpecies {

  @Id
  private Integer id;
  private Integer generationId;
  @OneToMany(mappedBy = "pokemonSpecies")
  private List<Pokemon> pokemonList;
  @OneToMany(mappedBy = "pokemonSpecies")
  private List<PokemonSpeciesName> pokemonSpeciesNames;
  @OneToMany(mappedBy = "pokemonSpecies")
  private List<PokemonFactory> pokemonFactories;

  public PokemonSpecies() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getGenerationId() {
    return generationId;
  }

  public void setGenerationId(Integer generationId) {
    this.generationId = generationId;
  }

  public List<Pokemon> getPokemonList() {
    return pokemonList;
  }

  public void setPokemonList(List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
  }

  public List<PokemonSpeciesName> getPokemonSpeciesNames() {
    return pokemonSpeciesNames;
  }

  public void setPokemonSpeciesNames(List<PokemonSpeciesName> pokemonSpeciesNames) {
    this.pokemonSpeciesNames = pokemonSpeciesNames;
  }

  public List<PokemonFactory> getPokemonFactories() {
    return pokemonFactories;
  }

  public void setPokemonFactories(List<PokemonFactory> pokemonFactories) {
    this.pokemonFactories = pokemonFactories;
  }

  @Override
  public String toString() {
    return "PokemonSpecies{" +
        "id=" + id +
        ", generationId=" + generationId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonSpecies that = (PokemonSpecies) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}