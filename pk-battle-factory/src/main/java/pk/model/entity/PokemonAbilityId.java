package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PokemonAbilityId implements Serializable {

  private Integer pokemonId;
  private Integer abilityId;

  public PokemonAbilityId() {
  }

  public Integer getPokemonId() {
    return pokemonId;
  }

  public void setPokemonId(Integer pokemonId) {
    this.pokemonId = pokemonId;
  }

  public Integer getAbilityId() {
    return abilityId;
  }

  public void setAbilityId(Integer abilityId) {
    this.abilityId = abilityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonAbilityId that = (PokemonAbilityId) o;

    if (pokemonId != null ? !pokemonId.equals(that.pokemonId) : that.pokemonId != null) return false;
    return abilityId != null ? abilityId.equals(that.abilityId) : that.abilityId == null;
  }

  @Override
  public int hashCode() {
    int result = pokemonId != null ? pokemonId.hashCode() : 0;
    result = 31 * result + (abilityId != null ? abilityId.hashCode() : 0);
    return result;
  }
}

