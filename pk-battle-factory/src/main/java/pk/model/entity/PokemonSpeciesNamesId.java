package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 02/07/2017.
 */
@Embeddable
public class PokemonSpeciesNamesId implements Serializable {

  private Integer pokemonSpeciesId;
  private Integer localLanguageId;

  public Integer getPokemonSpeciesId() {
    return pokemonSpeciesId;
  }

  public void setPokemonSpeciesId(Integer pokemonSpeciesId) {
    this.pokemonSpeciesId = pokemonSpeciesId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonSpeciesNamesId that = (PokemonSpeciesNamesId) o;

    if (pokemonSpeciesId != null ? !pokemonSpeciesId.equals(that.pokemonSpeciesId) : that.pokemonSpeciesId != null)
      return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = pokemonSpeciesId != null ? pokemonSpeciesId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PokemonSpeciesNamesId{" +
        "pokemonSpeciesId=" + pokemonSpeciesId +
        ", localLanguageId=" + localLanguageId +
        '}';
  }
}
