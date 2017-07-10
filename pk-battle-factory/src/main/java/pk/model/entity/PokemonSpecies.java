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
  @OneToMany(mappedBy = "pokemonSpecies")
  private List<Pokemon> pokemonList;
  @OneToMany(mappedBy = "pokemonSpecies")
  private List<PokemonSpeciesName> pokemonSpeciesNames;

  public PokemonSpecies() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "PokemonSpecies{" +
        "id=" + id +
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