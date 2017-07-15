package pk.model.dto;

import org.jetbrains.annotations.NotNull;
import pk.model.projection.PokemonFactoryProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Germain on 03/07/2017.
 */
public class PokemonFactoryDTO implements PokemonFactoryProjection {

  private Integer id;
  private String pkName;
  private String natureName;
  private String itemName;
  private List<Integer> stats;
  private List<String> moves;
  private String encounter100;

  public PokemonFactoryDTO(PokemonFactoryProjection p, List<Integer> stats, List<String> moves) {
    this.id = p.getId();
    this.pkName = p.getPkName();
    this.natureName = p.getNatureName();
    this.itemName = p.getItemName();
    this.stats = stats;
    this.moves = moves;
    this.encounter100 = p.getEncounter100();
  }

  public PokemonFactoryDTO(List<Object> values) {
    pkName = String.valueOf(values.get(0));
    natureName = String.valueOf(values.get(1));
    itemName = String.valueOf(values.get(2));
    stats = new ArrayList<>(6);
    for (int i = 3; i <= 8; i++) {
      stats.add((Integer) values.get(i));
    }
    moves = new ArrayList<>(4);
    for (int i = 9; i <= 12; i++) {
      moves.add(String.valueOf(values.get(i)));
    }
    encounter100 = String.valueOf(values.get(13));
  }

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getPkName() {
    return pkName;
  }

  public void setPkName(String pkName) {
    this.pkName = pkName;
  }

  @Override
  public String getNatureName() {
    return natureName;
  }

  public void setNatureName(String natureName) {
    this.natureName = natureName;
  }

  @Override
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public List<Integer> getStats() {
    return stats;
  }

  public void setStats(List<Integer> stats) {
    this.stats = stats;
  }

  public List<String> getMoves() {
    return moves;
  }

  public void setMoves(List<String> moves) {
    this.moves = moves;
  }

  @Override
  public String getEncounter100() {
    return encounter100;
  }

  public void setEncounter100(String encounter100) {
    this.encounter100 = encounter100;
  }

  @Override
  public String toString() {
    return "PokemonFactoryDTO{" +
        "id=" + id +
        ", pkName='" + pkName + '\'' +
        ", natureName='" + natureName + '\'' +
        ", itemName='" + itemName + '\'' +
        ", stats='" + getStringOfList(stats) +
        ", moves='" + getStringOfList(moves) +
        ", encounter100='" + encounter100 + '\'' +
        '}';
  }

  @NotNull
  private String getStringOfList(List<?> list) {
    return list.stream()
        .filter(Objects::nonNull)
        .map(Object::toString)
        .collect(Collectors.joining(", ")) + '\'';
  }

  public boolean compareWithoutId(PokemonFactoryDTO other) {
    if (pkName != null ? !pkName.equals(other.pkName) : other.pkName != null) return false;
    if (natureName != null ? !natureName.equals(other.natureName) : other.natureName != null) return false;
    if (itemName != null ? !itemName.equals(other.itemName) : other.itemName != null) return false;
    if (stats != null ? !stats.equals(other.stats) : other.stats != null) return false;
    if (moves != null ? !moves.equals(other.moves) : other.moves != null) return false;
    return encounter100 != null ? encounter100.equals(other.encounter100) : other.encounter100 == null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonFactoryDTO that = (PokemonFactoryDTO) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (pkName != null ? !pkName.equals(that.pkName) : that.pkName != null) return false;
    if (natureName != null ? !natureName.equals(that.natureName) : that.natureName != null) return false;
    if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
    if (stats != null ? !stats.equals(that.stats) : that.stats != null) return false;
    if (moves != null ? !moves.equals(that.moves) : that.moves != null) return false;
    return encounter100 != null ? encounter100.equals(that.encounter100) : that.encounter100 == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (pkName != null ? pkName.hashCode() : 0);
    result = 31 * result + (natureName != null ? natureName.hashCode() : 0);
    result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
    result = 31 * result + (stats != null ? stats.hashCode() : 0);
    result = 31 * result + (moves != null ? moves.hashCode() : 0);
    result = 31 * result + (encounter100 != null ? encounter100.hashCode() : 0);
    return result;
  }
}
