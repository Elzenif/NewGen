package pk.view;

import pk.model.entity.MoveName;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.TypeName;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;

import javax.swing.JPanel;
import java.util.List;
import java.util.Locale;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends JPanel implements PkGenerationAware {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final TypeNameRepository typeNameRepository;
  private final MoveNameRepository moveNameRepository;

  protected PkInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                      TypeNameRepository typeNameRepository, MoveNameRepository moveNameRepository) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.typeNameRepository = typeNameRepository;
    this.moveNameRepository = moveNameRepository;
  }

  protected Object[] getAllPokemonSpeciesNames(Integer generationMin, Integer generationMax) {
    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(language, generationMin, generationMax);
    return pokemonSpeciesNames.stream().map(PokemonSpeciesName::getName).toArray();
  }

  protected Object[] getAllTypeNames(Integer generationMin, Integer generationMax) {
    String language = Locale.getDefault().getLanguage();
    List<TypeName> typeNames = typeNameRepository.findAllByLanguage(language, generationMin, generationMax);
    return typeNames.stream().map(TypeName::getName).toArray();
  }

  protected Object[] getAllMoveNames(Integer generationMin, Integer generationMax) {
    String language = Locale.getDefault().getLanguage();
    List<MoveName> moveNames = moveNameRepository.findAllByLanguage(language, generationMin, generationMax);
    return moveNames.stream().map(MoveName::getName).toArray();
  }
}
