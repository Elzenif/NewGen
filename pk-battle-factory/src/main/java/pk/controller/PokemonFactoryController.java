package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.MoveName;
import pk.model.entity.PokemonFactoryStat;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonFactoryStatRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 03/07/2017.
 */
@Component
public class PokemonFactoryController {

  private final PokemonFactoryRepository pokemonFactoryRepository;
  private final PokemonFactoryStatRepository pokemonFactoryStatRepository;
  private final MoveNameRepository moveNameRepository;

  @Autowired
  public PokemonFactoryController(PokemonFactoryRepository pokemonFactoryRepository,
                                  PokemonFactoryStatRepository pokemonFactoryStatRepository,
                                  MoveNameRepository moveNameRepository) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
    this.pokemonFactoryStatRepository = pokemonFactoryStatRepository;
    this.moveNameRepository = moveNameRepository;
  }

  public List<PokemonFactoryDTO> findByName(String name) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByName(name, language).stream(), language);
  }

  public List<PokemonFactoryDTO> findByType(String type) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByType(type, language).stream(), language);
  }

  private List<PokemonFactoryDTO> find(Stream<PokemonFactoryProjection> projections, String language) {
    return projections
        .map(p -> new PokemonFactoryDTO(p,
            pokemonFactoryStatRepository.find(p.getId())
                .stream()
                .map(PokemonFactoryStat::getEv)
                .collect(Collectors.toList()),
            moveNameRepository.find(p.getId(), language)
                .stream()
                .map(MoveName::getName)
                .collect(Collectors.toList())))
        .collect(Collectors.toList());
  }
}
