package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 03/07/2017.
 */
@Entity
@Table(name = "pokemon_factory_hgss_stats")
public class PokemonFactoryStat {

  @EmbeddedId
  private PokemonFactoryStatId id;
  @MapsId("pokemonFactoryId")
  @JoinColumn(name = "pokemon_factory_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonFactory pokemonFactory;
  @MapsId("statId")
  @JoinColumn(name = "stat_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Stat stat;
  private Integer ev;

  public PokemonFactoryStat() {
  }

  public PokemonFactoryStatId getId() {
    return id;
  }

  public void setId(PokemonFactoryStatId id) {
    this.id = id;
  }

  public PokemonFactory getPokemonFactory() {
    return pokemonFactory;
  }

  public void setPokemonFactory(PokemonFactory pokemonFactory) {
    this.pokemonFactory = pokemonFactory;
  }

  public Stat getStat() {
    return stat;
  }

  public void setStat(Stat stat) {
    this.stat = stat;
  }

  public Integer getEv() {
    return ev;
  }

  public void setEv(Integer ev) {
    this.ev = ev;
  }

  @Override
  public String toString() {
    return "PokemonFactoryStat{" +
        "id=" + id +
        ", pokemonFactory=" + pokemonFactory.getId() +
        ", stat=" + stat.getId() +
        ", ev=" + ev +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonFactoryStat that = (PokemonFactoryStat) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}