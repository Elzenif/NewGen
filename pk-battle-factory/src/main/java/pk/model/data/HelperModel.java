package pk.model.data;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import commons.Constants;
import commons.utils.Pair;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;
import pk.model.entity.TypeEfficacy;
import pk.model.repository.TypeEfficacyRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class HelperModel {

  private final TypeEfficacyRepository typeEfficacyRepository;

  private Set<PokemonFactoryDTO> ownPokemons;
  private Set<PokemonFactoryDTO> opponentPokemons;
  private Table<Type, Type, Integer> efficacyTable = HashBasedTable.create(17, 17);
  private Table<PokemonFactoryDTO, Type, Float> typeMultiplierTable;

  public HelperModel(TypeEfficacyRepository typeEfficacyRepository) {
    this.typeEfficacyRepository = typeEfficacyRepository;
  }

  @PostConstruct
  public void init() {
    List<TypeEfficacy> typeEfficiencies = typeEfficacyRepository.findAll(Constants.GENERATION);

    for (TypeEfficacy typeEfficacy : typeEfficiencies) {
      efficacyTable.put(typeEfficacy.getDamageType(), typeEfficacy.getTargetType(), typeEfficacy.getDamageFactor());
    }
  }

  public void compute(Pair<Set<PokemonFactoryDTO>, Set<PokemonFactoryDTO>> selectedPokemons) {
    ownPokemons = selectedPokemons.getLeft();
    opponentPokemons = selectedPokemons.getRight();

    // Type multiplier
    computeTypeMultiplierTable();
  }

  private void computeTypeMultiplierTable() {
    typeMultiplierTable = HashBasedTable.create(ownPokemons.size() + 1, efficacyTable.rowKeySet().size());

    for (PokemonFactoryDTO ownPokemon : ownPokemons) {
      for (Type damageType : efficacyTable.rowKeySet()) {
        Float damageFactor = 100f;
        for (Type targetType : ownPokemon.getTypes()) {
          damageFactor *= efficacyTable.get(damageType, targetType) / 100f;
        }
        typeMultiplierTable.put(ownPokemon, damageType, damageFactor);
      }
    }
  }

  public Set<PokemonFactoryDTO> getOwnPokemons() {
    return ownPokemons;
  }

  public Set<PokemonFactoryDTO> getOpponentPokemons() {
    return opponentPokemons;
  }

  public Table<Type, Type, Integer> getEfficacyTable() {
    return efficacyTable;
  }

  public Table<PokemonFactoryDTO, Type, Float> getTypeMultiplierTable() {
    return typeMultiplierTable;
  }
}
