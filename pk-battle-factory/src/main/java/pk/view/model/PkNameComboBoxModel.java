package pk.view.model;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkNameComboBoxModel implements PkComboBoxModel<PokemonSpeciesName> {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;

  @Autowired
  public PkNameComboBoxModel(PokemonSpeciesNameRepository pokemonSpeciesNameRepository) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
  }

  @Override
  public List<PokemonSpeciesName> getAllElements() {
    return pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(Locale.getDefault().getLanguage(), Constants.GENERATION);
  }

  @Override
  public Function<PokemonSpeciesName, String> getCaptionGenerator() {
    return PokemonSpeciesName::getName;
  }
}
