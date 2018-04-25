package pk.model.dto;

import commons.utils.StringUtils;
import org.jetbrains.annotations.NotNull;
import pk.model.projection.PokemonFactoryProjection;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 03/07/2017.
 */
public class PokemonFactoryDTO implements PokemonFactoryProjection {

  public static final List<String> STAT_NAMES = Arrays.asList(
      resourceBundle.getString("hp"),
      resourceBundle.getString("atk"),
      resourceBundle.getString("def"),
      resourceBundle.getString("spAtk"),
      resourceBundle.getString("spDef"),
      resourceBundle.getString("speed"));
  private Integer id;
  private String pkName;
  private String natureName;
  private String itemName;
  private Map<Integer, Integer> stats = new LinkedHashMap<>(6);
  private Map<Integer, String> moves = new LinkedHashMap<>(4);
  private String encounter50;
  private String encounter100;

  public PokemonFactoryDTO() {
    for (int i = 1; i <= 6; i++) {
      stats.put(i, 0);
    }
    for (int i = 1; i <= 4; i++) {
      moves.put(i, null);
    }
  }

  public PokemonFactoryDTO(PokemonFactoryProjection p, List<Integer> stats, List<String> moves) {
    this.id = p.getId();
    this.pkName = p.getPkName();
    this.natureName = p.getNatureName();
    this.itemName = p.getItemName();
    int j = 1;
    for (Integer stat : stats) {
      this.stats.put(j, stat);
      j++;
    }
    int movesSize = moves.size();
    for (int i = 1; i <= movesSize; i++) {
      this.moves.put(i, moves.get(i - 1));
    }
    for (int i = 4 - movesSize; i >= 1; i--) {
      this.moves.put(i, null);
    }
    this.encounter50 = p.getEncounter50();
    this.encounter100 = p.getEncounter100();
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

  public Map<Integer, Integer> getStats() {
    return stats;
  }

  public void setStats(Map<Integer, Integer> stats) {
    this.stats = stats;
  }

  public Map<Integer, String> getMoves() {
    return moves;
  }

  public void setMoves(Map<Integer, String> moves) {
    this.moves = moves;
  }

  @Override
  public String getEncounter50() {
    return encounter50;
  }

  public void setEncounter50(String encounter50) {
    this.encounter50 = encounter50;
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
        ", stats='" + getStringOfList(stats.values()) + '\'' +
        ", moves='" + getStringOfList(moves.values()) + '\'' +
        ", encounter50='" + encounter50 + '\'' +
        ", encounter100='" + encounter100 + '\'' +
        '}';
  }

  @NotNull
  private String getStringOfList(Collection<?> list) {
    return list.stream()
        .filter(Objects::nonNull)
        .map(Object::toString)
        .collect(Collectors.joining(", "));
  }

  public String prettyPrint() {
    String s = pkName;
    s += StringUtils.isNull(itemName) ? "" : (" @ " + itemName);
    s += '\n';
    s += StringUtils.isNull(natureName) ? "" : natureName;
    s += '\n';
    s += IntStream.rangeClosed(1, 6).boxed()
        .filter(i -> stats.get(i) != 0)
        .map(i -> stats.get(i) + " " + STAT_NAMES.get(i))
        .collect(Collectors.joining(" / ")) + '\n';
    s += " - " + moves.values().stream()
        .filter(move -> !StringUtils.isNull(move))
        .collect(Collectors.joining("\n - "));
    return s;
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
    if (encounter50 != null ? !encounter50.equals(that.encounter50) : that.encounter50 != null) return false;
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
    result = 31 * result + (encounter50 != null ? encounter50.hashCode() : 0);
    result = 31 * result + (encounter100 != null ? encounter100.hashCode() : 0);
    return result;
  }
}
