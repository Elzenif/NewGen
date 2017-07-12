package pk.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "pokemon_factory_hgss")
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
  @OneToMany(mappedBy = "pokemonFactory")
  private List<PokemonFactoryStat> pokemonFactoryStats;
  @ManyToMany
	@JoinTable(name = "pokemon_factory_hgss_moves",
          joinColumns = @JoinColumn(name = "pokemon_factory_id", referencedColumnName = "id", nullable = false,
                  foreignKey = @ForeignKey(name = "pokemon_factory_hgss_moves_pokemon_factory_id")),
          inverseJoinColumns = @JoinColumn(name = "move_id", referencedColumnName = "id", nullable = false),
                  foreignKey = @ForeignKey(name = "pokemon_factory_hgss_moves_move_id"))
  private List<Move> moves;
  private String encounter100;

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

  public List<PokemonFactoryStat> getPokemonFactoryStats() {
    return pokemonFactoryStats;
  }

  public void setPokemonFactoryStats(List<PokemonFactoryStat> pokemonFactoryStats) {
    this.pokemonFactoryStats = pokemonFactoryStats;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }

  public String getEncounter100() {
    return encounter100;
  }

  public void setEncounter100(String encounter100) {
    this.encounter100 = encounter100;
  }

  @Override
  public String toString() {
    return "PokemonFactory{" +
        "id=" + id +
        ", pokemonSpecies=" + pokemonSpecies.getId() +
        ", nature=" + nature.getId() +
        ", item=" + item.getId() +
        ", encounter100='" + encounter100 + '\'' +
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