package pk.view.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PokemonSpeciesNamesComboBoxModel extends DefaultComboBoxModel<Object> {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final OptionMenu optionMenu;
  private final GetAllFunction getAllFunction;

  @Autowired
  public PokemonSpeciesNamesComboBoxModel(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                                          OptionMenu optionMenu) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.optionMenu = optionMenu;
    getAllFunction = this::getAllPokemonSpeciesNames;
  }

  @PostConstruct
  public void init() {
    addAll(1, optionMenu.getSelectedGeneration());
  }

  private Object[] getAllPokemonSpeciesNames(Integer generationMin, Integer generationMax) {
    return pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(PokemonSpeciesName::getName)
        .toArray();
  }

  public GetAllFunction getGetAllFunction() {
    return getAllFunction;
  }

  public void addAll(Integer generationMin, Integer generationMax) {
    for (Object item : getAllFunction.apply(generationMin, generationMax)) {
      addElement(item);
    }
  }
}
