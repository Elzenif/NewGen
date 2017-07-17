package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 17/07/2017.
 */
@Embeddable
public class PokemonStatId implements Serializable {

  private Integer pokemonId;
  private Integer statId;

  public PokemonStatId() {
  }

  public Integer getPokemonId() {
    return pokemonId;
  }

  public void setPokemonId(Integer pokemonId) {
    this.pokemonId = pokemonId;
  }

  public Integer getStatId() {
    return statId;
  }

  public void setStatId(Integer statId) {
    this.statId = statId;
  }

  @Override
  public String toString() {
    return "PokemonStatId{" +
        "pokemonId=" + pokemonId +
        ", statId=" + statId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonStatId that = (PokemonStatId) o;

    if (pokemonId != null ? !pokemonId.equals(that.pokemonId) : that.pokemonId != null) return false;
    return statId != null ? statId.equals(that.statId) : that.statId == null;
  }

  @Override
  public int hashCode() {
    int result = pokemonId != null ? pokemonId.hashCode() : 0;
    result = 31 * result + (statId != null ? statId.hashCode() : 0);
    return result;
  }
}

