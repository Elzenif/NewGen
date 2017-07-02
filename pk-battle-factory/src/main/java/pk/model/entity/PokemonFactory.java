package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "pokemon_factory")
public class PokemonFactory {

  @Id
  private Integer id;
  @JoinColumn(name = "pokemon_species_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonSpecies pokemonSpecies;
  @JoinColumn(name = "nature_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Nature nature;
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;

  public PokemonFactory() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PokemonSpecies getPokemonSpecies() {
    return pokemonSpecies;
  }

  public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
    this.pokemonSpecies = pokemonSpecies;
  }

  public Nature getNature() {
    return nature;
  }

  public void setNature(Nature nature) {
    this.nature = nature;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "PokemonFactory{" +
        "id=" + id +
        ", pokemonSpecies=" + pokemonSpecies.getId() +
        ", nature=" + nature.getId() +
        ", item=" + item.getId() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonFactory that = (PokemonFactory) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}