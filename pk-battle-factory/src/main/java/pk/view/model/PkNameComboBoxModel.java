package pk.view.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkNameComboBoxModel extends PkComboBoxModel {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;

  @Autowired
  public PkNameComboBoxModel(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                             OptionMenu optionMenu) {
    super(optionMenu);
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    getAllFunction = this::getAllPokemonSpeciesNames;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  private Object[] getAllPokemonSpeciesNames(Integer generationMin, Integer generationMax) {
    return pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(PokemonSpeciesName::getName)
        .toArray();
  }
}
