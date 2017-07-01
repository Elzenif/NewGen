package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "pokemon_species_names")
public class PokemonSpeciesNames {

  @EmbeddedId
  private PokemonSpeciesNamesId id;
  private String name;
  private String genus;

  public PokemonSpeciesNamesId getId() {
    return id;
  }

  public void setId(PokemonSpeciesNamesId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  @Override
  public String toString() {
    return "PokemonSpeciesNames{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", genus='" + genus + '\'' +
        '}';
  }
}
