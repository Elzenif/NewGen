package pk.controller;

import commons.utils.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.ItemName;
import pk.model.entity.MoveName;
import pk.model.entity.Nature;
import pk.model.entity.NatureName;
import pk.model.entity.PokemonFactory;
import pk.model.entity.PokemonFactoryStat;
import pk.model.entity.PokemonFactoryStatId;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.PokemonStat;
import pk.model.entity.Stat;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.ItemNameRepository;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.NatureNameRepository;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonFactoryStatRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.PokemonStatRepository;
import pk.model.repository.StatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
  private final PokemonStatRepository pokemonStatRepository;

  private double level = 100;
  private double iv = 0;


  @Autowired
  public PokemonFactoryController(PokemonFactoryRepository pokemonFactoryRepository,
                                  PokemonFactoryStatRepository pokemonFactoryStatRepository,
                                  MoveNameRepository moveNameRepository,
                                  PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                                  NatureNameRepository natureNameRepository,
                                  ItemNameRepository itemNameRepository,
                                  StatRepository statRepository,
                                  PokemonStatRepository pokemonStatRepository) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
    this.pokemonFactoryStatRepository = pokemonFactoryStatRepository;
    this.moveNameRepository = moveNameRepository;
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.natureNameRepository = natureNameRepository;
    this.itemNameRepository = itemNameRepository;
    this.statRepository = statRepository;
    this.pokemonStatRepository = pokemonStatRepository;
  }

  public Stream<PokemonFactoryDTO> findByName(String name) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByName(name, language).stream(), language);
  }

  public Stream<PokemonFactoryDTO> findByType(String type) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByType(type, language).stream(), language);
  }

  public Stream<PokemonFactoryDTO> findByMove(String move) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByMove(move, language).stream(), language);
  }

  private Stream<PokemonFactoryDTO> find(Stream<PokemonFactoryProjection> projections, String language) {
    return projections
        .map(p -> new PokemonFactoryDTO(p,
            pokemonFactoryStatRepository.find(p.getId())
                .stream()
                .map(PokemonFactoryStat::getEv)
                .collect(Collectors.toList()),
            moveNameRepository.find(p.getId(), language)
                .stream()
                .map(MoveName::getName)
                .collect(Collectors.toList())));
  }

  @Transactional
  public void insertNewPokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, new PokemonFactory());
  }

  @Transactional
  public void update(PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, pokemonFactoryRepository.getOne(pokemonFactoryDTO.getId()));
  }

  private void savePokemonFactory(PokemonFactoryDTO pokemonFactoryDTO, PokemonFactory pokemonFactory) {
    String language = Locale.getDefault().getLanguage();

    PokemonSpeciesName pokemonSpeciesName = pokemonSpeciesNameRepository
        .findByName(pokemonFactoryDTO.getPkName(), language);
    if (pokemonSpeciesName == null) {
      LOGGER.error(String.format("Cannot save without a valid name: %s", pokemonFactoryDTO.getPkName()));
      return;
    }
    pokemonFactory.setPokemonSpecies(pokemonSpeciesName.getPokemonSpecies());

    NatureName natureName = natureNameRepository.findByName(pokemonFactoryDTO.getNatureName(), language);
    pokemonFactory.setNature(natureName == null ? null : natureName.getNature());

    ItemName itemName = itemNameRepository.findByName(pokemonFactoryDTO.getItemName(), language);
    pokemonFactory.setItem(itemName == null ? null : itemName.getItem());

    pokemonFactory.setEncounter50(pokemonFactoryDTO.getEncounter50());
    pokemonFactory.setEncounter100(pokemonFactoryDTO.getEncounter100());

    pokemonFactory = pokemonFactoryRepository.save(pokemonFactory);

    List<PokemonFactoryStat> pokemonFactoryStats = new ArrayList<>(6);
    for (Map.Entry<Integer, Integer> entry : pokemonFactoryDTO.getStats().entrySet()) {
      PokemonFactoryStat pokemonFactoryStat = new PokemonFactoryStat();
      pokemonFactoryStat.setId(new PokemonFactoryStatId(pokemonFactory.getId(), entry.getKey()));
      pokemonFactoryStat.setPokemonFactory(pokemonFactory);
      Stat stat = statRepository.getOne(entry.getKey());
      pokemonFactoryStat.setStat(stat);
      pokemonFactoryStat.setEv(entry.getValue() == null ? 0 : entry.getValue());
      pokemonFactoryStats.add(pokemonFactoryStat);
    }
    pokemonFactoryStatRepository.saveAll(pokemonFactoryStats);
    pokemonFactory.setPokemonFactoryStats(pokemonFactoryStats);

    List<MoveName> moveNames = moveNameRepository.findByNames(pokemonFactoryDTO.getMoves().values(), language);
    pokemonFactory.setMoves(moveNames.stream().map(MoveName::getMove).collect(Collectors.toList()));

    pokemonFactoryRepository.save(pokemonFactory);
  }

  public String printStats(PokemonFactoryDTO pokemonFactoryDTO) {
    List<PokemonStat> pokemonStats = pokemonStatRepository.findStats(pokemonFactoryDTO.getId());
    Nature nature;
    if (StringUtils.isNull(pokemonFactoryDTO.getNatureName())) {
      nature = null;
    } else {
      String language = Locale.getDefault().getLanguage();
      NatureName natureName = natureNameRepository.findByName(pokemonFactoryDTO.getNatureName(), language);
      nature = natureName.getNature();
    }
    return IntStream.rangeClosed(0, 5).boxed()
        .map(i -> printStat(i, pokemonStats.get(i), pokemonFactoryDTO.getStats().get(i), nature))
        .collect(Collectors.joining("\n"));
  }

  private String printStat(Integer index, PokemonStat pokemonStat, Integer ev, Nature nature) {
    String s = PokemonFactoryDTO.STAT_NAMES.get(index);
    double natureBonus = getBonusFromNature(index + 1, nature);
    s += "\t" + (index == 0 ? getHPFormula(pokemonStat, ev) : getOtherFormula(pokemonStat, ev, natureBonus));
    return s;
  }

  private double getBonusFromNature(Integer index, Nature nature) {
    if (nature == null || nature.getIncreasedStat() == nature.getDecreasedStat()) {
      return 1;
    } else if (Objects.equals(nature.getIncreasedStat().getId(), index)) {
      return 1.1;
    } else if (Objects.equals(nature.getDecreasedStat().getId(), index)) {
      return 0.9;
    } else {
      return 1;
    }
  }

  @NotNull
  private String getOtherFormula(PokemonStat pokemonStat, int ev, double natureBonus) {
    // Others:  (((IV + 2 * BaseStat + (EV/4) ) * Level/100 ) + 5) * Nature Value
    return String.valueOf((int) (((int) (((2.0 * pokemonStat.getBaseStat() + iv + (ev / 4)) * level) / 100.0) + 5) * natureBonus));
  }

  @NotNull
  private String getHPFormula(PokemonStat pokemonStat, int ev) {
    // HP :     (((IV + 2 * BaseStat + (EV/4) ) * Level/100 ) + 10 + Level

    return String.valueOf((int) ((int) (((2.0 * pokemonStat.getBaseStat() + iv + (ev / 4)) * level) / 100.0) + 10 + level));
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setIv(int iv) {
    this.iv = iv;
  }
}
