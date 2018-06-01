package pk.model.dto;

import org.jetbrains.annotations.NotNull;
import pk.model.entity.Ability;
import pk.model.entity.Type;
import pk.model.projection.PokemonFactoryProjection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Germain on 03/07/2017.
 */
public class PokemonFactoryDTO implements PokemonFactoryProjection {

  private Integer id;
  private String pkName;
  private String natureName;
  private String itemName;
  private Map<Integer, Integer> stats = new LinkedHashMap<>(6);
  private Map<Integer, String> moves = new LinkedHashMap<>(4);
  private String encounter50;
  private String encounter100;
  private Integer pokemonSpeciesId;
  private List<Type> types = new ArrayList<>(2);
  private List<Ability> potentialAbilities = new ArrayList<>(2);

  public PokemonFactoryDTO() {
    for (int i = 1; i <= 6; i++) {
      stats.put(i, 0);
    }
    for (int i = 1; i <= 4; i++) {
      moves.put(i, null);
    }
  }

  public PokemonFactoryDTO(@NotNull PokemonFactoryProjection p, @NotNull List<Integer> stats, List<String> moves,
                           List<Type> types, List<Ability> potentialAbilities) {
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
    for (int i = 4; i >= 1 + movesSize; i--) {
      this.moves.put(i, null);
    }
    this.encounter50 = p.getEncounter50();
    this.encounter100 = p.getEncounter100();
    this.pokemonSpeciesId = p.getPokemonSpeciesId();
    this.types = types;
    this.potentialAbilities = potentialAbilities;
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
  public Integer getPokemonSpeciesId() {
    return pokemonSpeciesId;
  }

  public void setPokemonSpeciesId(Integer pokemonSpeciesId) {
    this.pokemonSpeciesId = pokemonSpeciesId;
  }

  public List<Type> getTypes() {
    return types;
  }

  public void setTypes(List<Type> types) {
    this.types = types;
  }

  public List<Ability> getPotentialAbilities() {
    return potentialAbilities;
  }

  public void setPotentialAbilities(List<Ability> potentialAbilities) {
    this.potentialAbilities = potentialAbilities;
  }

  @Override
  public String toString() {
    return "PokemonFactoryDTO{" +
        "id=" + id +
        ", pkName='" + pkName + '\'' +
        ", natureName='" + natureName + '\'' +
        ", itemName='" + itemName + '\'' +
        ", stats='" + getStringOfList(stats.values(), Object::toString) + '\'' +
        ", moves='" + getStringOfList(moves.values(), Object::toString) + '\'' +
        ", encounter50='" + encounter50 + '\'' +
        ", encounter100='" + encounter100 + '\'' +
        ", pokemonSpeciesId=" + pokemonSpeciesId +
        ", types='" + getStringOfList(types, Type::getIdentifier) + '\'' +
        ", potentialAbilities='" + getStringOfList(potentialAbilities, Ability::getIdentifier) + '\'' +
        '}';
  }

  @NotNull
  private <T> String getStringOfList(@NotNull Collection<T> list, Function<T, String> stringFunction) {
    return list.stream()
        .filter(Objects::nonNull)
        .map(stringFunction)
        .collect(Collectors.joining(", "));
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
