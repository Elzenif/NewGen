package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 10/07/2017.
 */
@Entity
@Table(name = "pokemon_types")
public class PokemonType {

  @EmbeddedId
  private PokemonTypeId id;
  @MapsId("pokemonId")
  @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Pokemon pokemon;
  @MapsId("typeId")
  @JoinColumn(name = "type_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Type type;

  public PokemonType() {
  }

  public PokemonTypeId getId() {
    return id;
  }

  public void setId(PokemonTypeId id) {
    this.id = id;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "PokemonType{" +
        "id=" + id +
        ", pokemon=" + pokemon.getId() +
        ", type=" + type.getId() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonType that = (PokemonType) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}