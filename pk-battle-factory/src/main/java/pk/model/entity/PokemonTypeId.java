package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 10/07/2017.
 */
@Embeddable
public class PokemonTypeId implements Serializable {

  private Integer pokemonId;
  private Integer typeId;

  public PokemonTypeId() {
  }

  public Integer getPokemonId() {
    return pokemonId;
  }

  public void setPokemonId(Integer pokemonId) {
    this.pokemonId = pokemonId;
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonTypeId that = (PokemonTypeId) o;

    if (pokemonId != null ? !pokemonId.equals(that.pokemonId) : that.pokemonId != null) return false;
    return typeId != null ? typeId.equals(that.typeId) : that.typeId == null;
  }

  @Override
  public int hashCode() {
    int result = pokemonId != null ? pokemonId.hashCode() : 0;
    result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
    return result;
  }
}

