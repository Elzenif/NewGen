package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 03/07/2017.
 */
@Embeddable
public class PokemonFactoryStatId implements Serializable {

  private Integer pokemonFactoryId;
  private Integer statId;

  public PokemonFactoryStatId() {
  }

  public Integer getPokemonFactoryId() {
    return pokemonFactoryId;
  }

  public void setPokemonFactoryId(Integer pokemonFactoryId) {
    this.pokemonFactoryId = pokemonFactoryId;
  }

  public Integer getStatId() {
    return statId;
  }

  public void setStatId(Integer statId) {
    this.statId = statId;
  }

  @Override
  public String toString() {
    return "PokemonFactoryStatId{" +
        "pokemonFactoryId=" + pokemonFactoryId +
        ", statId=" + statId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonFactoryStatId that = (PokemonFactoryStatId) o;

    if (pokemonFactoryId != null ? !pokemonFactoryId.equals(that.pokemonFactoryId) : that.pokemonFactoryId != null)
      return false;
    return statId != null ? statId.equals(that.statId) : that.statId == null;
  }

  @Override
  public int hashCode() {
    int result = pokemonFactoryId != null ? pokemonFactoryId.hashCode() : 0;
    result = 31 * result + (statId != null ? statId.hashCode() : 0);
    return result;
  }
}

