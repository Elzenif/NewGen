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
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;
  private String genus;

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

  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  @Override
  public String toString() {
    return "PokemonSpeciesName{" +
        "id=" + id +
        ", language=" + language +
        ", name='" + name + '\'' +
        ", genus='" + genus + '\'' +
        '}';
  }
}
