package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon_abilities")
public class PokemonAbility {

  @EmbeddedId
  private PokemonAbilityId id;
  @MapsId("pokemonId")
  @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Pokemon pokemon;
  @MapsId("abilityId")
  @JoinColumn(name = "ability_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Ability ability;
  private Boolean isHidden;

  public PokemonAbility() {
  }

  public PokemonAbilityId getId() {
    return id;
  }

  public void setId(PokemonAbilityId id) {
    this.id = id;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public Ability getAbility() {
    return ability;
  }

  public void setAbility(Ability ability) {
    this.ability = ability;
  }

  public Boolean getHidden() {
    return isHidden;
  }

  public void setHidden(Boolean hidden) {
    isHidden = hidden;
  }

  @Override
  public String toString() {
    return "PokemonAbility{" +
        "id=" + id +
        ", pokemon=" + pokemon.getId() +
        ", ability=" + ability.getId() +
        ", isHidden=" + isHidden +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonAbility that = (PokemonAbility) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}