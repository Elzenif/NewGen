package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 17/07/2017.
 */
@Entity
@Table(name = "pokemon_stats")
public class PokemonStat {

  @EmbeddedId
  private PokemonStatId pokemonStatId;
  @MapsId("pokemonId")
  @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Pokemon pokemon;
  @MapsId("statId")
  @JoinColumn(name = "stat_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Stat stat;
  private Integer baseStat;

  public PokemonStat() {
  }

  public PokemonStatId getPokemonStatId() {
    return pokemonStatId;
  }

  public void setPokemonStatId(PokemonStatId pokemonStatId) {
    this.pokemonStatId = pokemonStatId;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public Stat getStat() {
    return stat;
  }

  public void setStat(Stat stat) {
    this.stat = stat;
  }

  public Integer getBaseStat() {
    return baseStat;
  }

  public void setBaseStat(Integer baseStat) {
    this.baseStat = baseStat;
  }

  @Override
  public String toString() {
    return "PokemonStat{" +
        "pokemonStatId=" + pokemonStatId +
        ", pokemon=" + pokemon.getId() +
        ", stat=" + stat.getId() +
        ", baseStat=" + baseStat +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonStat that = (PokemonStat) o;

    return pokemonStatId != null ? pokemonStatId.equals(that.pokemonStatId) : that.pokemonStatId == null;
  }

  @Override
  public int hashCode() {
    return pokemonStatId != null ? pokemonStatId.hashCode() : 0;
  }
}