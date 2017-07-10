package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Germain on 10/07/2017.
 */
@Entity
@Table(name = "pokemon")
public class Pokemon {

  @Id
  private Integer id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "species_id", referencedColumnName = "id")
  private PokemonSpecies pokemonSpecies;
  @OneToMany(mappedBy = "pokemon")
  private List<PokemonType> pokemonTypes;

  public Pokemon() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PokemonSpecies getPokemonSpecies() {
    return pokemonSpecies;
  }

  public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
    this.pokemonSpecies = pokemonSpecies;
  }

  public List<PokemonType> getPokemonTypes() {
    return pokemonTypes;
  }

  public void setPokemonTypes(List<PokemonType> pokemonTypes) {
    this.pokemonTypes = pokemonTypes;
  }

  @Override
  public String toString() {
    return "Pokemon{" +
        "id=" + id +
        ", pokemonSpecies=" + pokemonSpecies.getId() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pokemon pokemon = (Pokemon) o;

    return id != null ? id.equals(pokemon.id) : pokemon.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}