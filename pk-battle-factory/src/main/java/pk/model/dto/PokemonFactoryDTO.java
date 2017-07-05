package pk.model.dto;

import pk.model.projection.PokemonFactoryProjection;

import java.util.List;
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

  public PokemonFactoryDTO(PokemonFactoryProjection p, List<Integer> stats) {
    this.id = p.getId();
    this.pkName = p.getPkName();
    this.natureName = p.getNatureName();
    this.itemName = p.getItemName();
    this.stats = stats;
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

  @Override
  public String toString() {
    return "PokemonFactoryProjectionImpl{" +
        "id=" + id +
        ", pkName='" + pkName + '\'' +
        ", natureName='" + natureName + '\'' +
        ", itemName='" + itemName + '\'' +
        ", stats='" + stats.stream().map(Object::toString).collect(Collectors.joining(", ")) + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PokemonFactoryDTO that = (PokemonFactoryDTO) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
