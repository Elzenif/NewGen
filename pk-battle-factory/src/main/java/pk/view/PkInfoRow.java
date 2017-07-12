package pk.view;

import pk.model.entity.MoveName;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.TypeName;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends JPanel implements PkGenerationAware {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final TypeNameRepository typeNameRepository;
  private final MoveNameRepository moveNameRepository;
  protected final Map<JComboBox<Object>, GetAllFunction> comboBoxMap;

  protected PkInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                      TypeNameRepository typeNameRepository, MoveNameRepository moveNameRepository) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.typeNameRepository = typeNameRepository;
    this.moveNameRepository = moveNameRepository;
    this.comboBoxMap = new HashMap<>();
  }

  protected Object[] getAllPokemonSpeciesNames(Integer generationMin, Integer generationMax) {
    return pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(PokemonSpeciesName::getName)
        .toArray();
  }

  protected Object[] getAllTypeNames(Integer generationMin, Integer generationMax) {
    return typeNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(TypeName::getName)
        .toArray();
  }

  protected Object[] getAllMoveNames(Integer generationMin, Integer generationMax) {
    return moveNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(MoveName::getName)
        .toArray();
  }

  private void removeAllFromComboBox(JComboBox<Object> comboBox, GetAllFunction function, Integer oldGeneration,
                                     Integer newGeneration) {
    for (Object item : function.apply(newGeneration + 1, oldGeneration)) {
      comboBox.removeItem(item);
    }
  }

  private void addAllToComboBox(JComboBox<Object> comboBox, GetAllFunction function, Integer oldGeneration,
                                Integer newGeneration) {
    for (Object item : function.apply(oldGeneration + 1, newGeneration)) {
      comboBox.addItem(item);
    }
  }

  @Override
  public void updateGeneration(int oldGeneration, int newGeneration) {
    if (oldGeneration > newGeneration) {
      comboBoxMap.forEach((comboBox, f) -> removeAllFromComboBox(comboBox, f, oldGeneration, newGeneration));
    } else if (oldGeneration < newGeneration) {
      comboBoxMap.forEach((comboBox, f) -> addAllToComboBox(comboBox, f, oldGeneration, newGeneration));
    }

  }

  @FunctionalInterface
  protected interface GetAllFunction {

    Object[] apply(Integer generationMin, Integer generationMax);
  }
}
