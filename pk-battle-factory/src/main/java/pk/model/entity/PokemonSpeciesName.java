package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "pokemon_species_names")
public class PokemonSpeciesName {

  @EmbeddedId
  private PokemonSpeciesNameId id;
  @MapsId("pokemonSpeciesId")
  @JoinColumn(name = "pokemon_species_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonSpecies pokemonSpecies;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public PokemonSpecies getPokemonSpecies() {
    return pokemonSpecies;
  }

  public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
    this.pokemonSpecies = pokemonSpecies;
  }

  public PokemonSpeciesNameId getId() {
    return id;
  }

  public void setId(PokemonSpeciesNameId id) {
    this.id = id;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "PokemonSpeciesName{" +
        ", pokemonSpecies=" + pokemonSpecies.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonSpeciesName that = (PokemonSpeciesName) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
