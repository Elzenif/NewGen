package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.PokemonFactoryStat;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonFactoryStatRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by Germain on 03/07/2017.
 */
@Component
public class PokemonFactoryController {

  private final PokemonFactoryRepository pokemonFactoryRepository;
  private final PokemonFactoryStatRepository pokemonFactoryStatRepository;

  @Autowired
  public PokemonFactoryController(PokemonFactoryRepository pokemonFactoryRepository,
                                  PokemonFactoryStatRepository pokemonFactoryStatRepository) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
    this.pokemonFactoryStatRepository = pokemonFactoryStatRepository;
  }

  public List<PokemonFactoryDTO> findByName(String name) {
    return pokemonFactoryRepository.find(name, Locale.getDefault().getLanguage())
        .stream()
        .map(p -> new PokemonFactoryDTO(p, pokemonFactoryStatRepository.find(p.getId())
            .stream()
            .map(PokemonFactoryStat::getEv)
            .collect(Collectors.toList())))
        .collect(Collectors.toList());
  }
}
