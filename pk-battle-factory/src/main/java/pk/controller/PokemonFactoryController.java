package pk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.ItemName;
import pk.model.entity.MoveName;
import pk.model.entity.NatureName;
import pk.model.entity.PokemonFactory;
import pk.model.entity.PokemonFactoryStat;
import pk.model.entity.PokemonFactoryStatId;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.Stat;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.ItemNameRepository;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.NatureNameRepository;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonFactoryStatRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.StatRepository;
import pk.view.menu.OptionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 03/07/2017.
 */
@Component
public class PokemonFactoryController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PokemonFactoryController.class);
  private final PokemonFactoryRepository pokemonFactoryRepository;
  private final PokemonFactoryStatRepository pokemonFactoryStatRepository;
  private final MoveNameRepository moveNameRepository;
  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final NatureNameRepository natureNameRepository;
  private final ItemNameRepository itemNameRepository;
  private final StatRepository statRepository;
  private final OptionMenu optionMenu;

  @Autowired
  public PokemonFactoryController(PokemonFactoryRepository pokemonFactoryRepository,
                                  PokemonFactoryStatRepository pokemonFactoryStatRepository,
                                  MoveNameRepository moveNameRepository,
                                  PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                                  NatureNameRepository natureNameRepository,
                                  ItemNameRepository itemNameRepository,
                                  StatRepository statRepository, OptionMenu optionMenu) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
    this.pokemonFactoryStatRepository = pokemonFactoryStatRepository;
    this.moveNameRepository = moveNameRepository;
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.natureNameRepository = natureNameRepository;
    this.itemNameRepository = itemNameRepository;
    this.statRepository = statRepository;
    this.optionMenu = optionMenu;
  }

  public List<PokemonFactoryDTO> findByName(String name) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByName(name, language).stream(), language);
  }

  public List<PokemonFactoryDTO> findByType(String type) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByType(type, language).stream(), language);
  }

  public List<PokemonFactoryDTO> findByMove(String move) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByMove(move, language).stream(), language);
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

  @Transactional
  public void insertNewPokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, new PokemonFactory());
  }

  @Transactional
  public void update(Integer id, PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, pokemonFactoryRepository.findOne(id));
  }

  private void savePokemonFactory(PokemonFactoryDTO pokemonFactoryDTO, PokemonFactory pokemonFactory) {
    String language = Locale.getDefault().getLanguage();

    PokemonSpeciesName pokemonSpeciesName = pokemonSpeciesNameRepository
        .findByName(pokemonFactoryDTO.getPkName(), language);
    pokemonFactory.setPokemonSpecies(pokemonSpeciesName.getPokemonSpecies());

    NatureName natureName = natureNameRepository.findByName(pokemonFactoryDTO.getNatureName(), language);
    if (natureName != null) {
      pokemonFactory.setNature(natureName.getNature());
    }

    ItemName itemName = itemNameRepository.findByName(pokemonFactoryDTO.getItemName(), language);
    if (itemName != null) {
      pokemonFactory.setItem(itemName.getItem());
    }

    pokemonFactory.setEncounter50(pokemonFactoryDTO.getEncounter50());
    pokemonFactory.setEncounter100(pokemonFactoryDTO.getEncounter100());

    pokemonFactory = pokemonFactoryRepository.save(pokemonFactory);

    List<PokemonFactoryStat> pokemonFactoryStats = new ArrayList<>(6);
    int i = 1;
    for (Integer ev : pokemonFactoryDTO.getStats()) {
      PokemonFactoryStat pokemonFactoryStat = new PokemonFactoryStat();
      pokemonFactoryStat.setId(new PokemonFactoryStatId(pokemonFactory.getId(), i));
      pokemonFactoryStat.setPokemonFactory(pokemonFactory);
      Stat stat = statRepository.findOne(i);
      pokemonFactoryStat.setStat(stat);
      pokemonFactoryStat.setEv(ev == null ? 0 : ev);
      i++;
      pokemonFactoryStats.add(pokemonFactoryStat);
    }
    pokemonFactoryStatRepository.save(pokemonFactoryStats);
    pokemonFactory.setPokemonFactoryStats(pokemonFactoryStats);

    List<MoveName> moveNames = moveNameRepository.findByName(pokemonFactoryDTO.getMoves(), language);
    pokemonFactory.setMoves(moveNames.stream().map(MoveName::getMove).collect(Collectors.toList()));

    pokemonFactoryRepository.save(pokemonFactory);
    LOGGER.info(pokemonFactory.toString());
  }
}
