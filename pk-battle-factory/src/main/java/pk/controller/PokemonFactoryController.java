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
import pk.model.entity.Pokemon;
import pk.model.entity.PokemonFactory;
import pk.model.entity.PokemonFactoryStat;
import pk.model.entity.PokemonFactoryStatId;
import pk.model.entity.PokemonStat;
import pk.model.entity.Stat;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.ItemNameRepository;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.NatureNameRepository;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonFactoryStatRepository;
import pk.model.repository.PokemonRepository;
import pk.model.repository.PokemonStatRepository;
import pk.model.repository.StatRepository;
import pk.model.repository.TypeRepository;
import pk.view.main.IVSlider;
import pk.view.main.LevelSlider;

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
  private final PokemonRepository pokemonRepository;
  private final NatureNameRepository natureNameRepository;
  private final ItemNameRepository itemNameRepository;
  private final StatRepository statRepository;
  private final PokemonStatRepository pokemonStatRepository;
  private final TypeRepository typeRepository;

  private double level = LevelSlider.DEFAULT_LEVEL;
  private double iv = IVSlider.DEFAULT_IV;


  @Autowired
  public PokemonFactoryController(PokemonFactoryRepository pokemonFactoryRepository,
                                  PokemonFactoryStatRepository pokemonFactoryStatRepository,
                                  MoveNameRepository moveNameRepository,
                                  PokemonRepository pokemonRepository,
                                  NatureNameRepository natureNameRepository,
                                  ItemNameRepository itemNameRepository,
                                  StatRepository statRepository,
                                  PokemonStatRepository pokemonStatRepository,
                                  TypeRepository typeRepository) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
    this.pokemonFactoryStatRepository = pokemonFactoryStatRepository;
    this.moveNameRepository = moveNameRepository;
    this.pokemonRepository = pokemonRepository;
    this.natureNameRepository = natureNameRepository;
    this.itemNameRepository = itemNameRepository;
    this.statRepository = statRepository;
    this.pokemonStatRepository = pokemonStatRepository;
    this.typeRepository = typeRepository;
  }

  public Stream<PokemonFactoryDTO> findByName(String name) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByNameAndLanguage(name, language).stream(), language);
  }

  public Stream<PokemonFactoryDTO> findByType(String type) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByTypeAndLanguage(type, language).stream(), language);
  }

  public Stream<PokemonFactoryDTO> findByMove(String move) {
    String language = Locale.getDefault().getLanguage();
    return find(pokemonFactoryRepository.findByMoveAndLanguage(move, language).stream(), language);
  }

  private Stream<PokemonFactoryDTO> find(@NotNull Stream<PokemonFactoryProjection> projections, String language) {
    return projections
        .map(p -> new PokemonFactoryDTO(p,
            pokemonFactoryStatRepository.find(p.getId())
                .stream()
                .map(PokemonFactoryStat::getEv)
                .collect(Collectors.toList()),
            moveNameRepository.find(p.getId(), language)
                .stream()
                .map(MoveName::getName)
                .collect(Collectors.toList()),
            typeRepository.find(p.getPokemonSpeciesId())));
  }

  @Transactional
  public void insertNewPokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, new PokemonFactory());
  }

  @Transactional
  public void update(PokemonFactoryDTO pokemonFactoryDTO) {
    savePokemonFactory(pokemonFactoryDTO, pokemonFactoryRepository.getOne(pokemonFactoryDTO.getId()));
  }

  private void savePokemonFactory(@NotNull PokemonFactoryDTO pokemonFactoryDTO, PokemonFactory pokemonFactory) {
    String language = Locale.getDefault().getLanguage();

    Pokemon pokemon = pokemonRepository.findByNameAndLanguage(pokemonFactoryDTO.getPkName(), language);
    if (pokemon == null) {
      LOGGER.error(String.format("Cannot save without a valid name: %s", pokemonFactoryDTO.getPkName()));
      return;
    }
    pokemonFactory.setPokemon(pokemon);

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

  public Map<Integer, Integer> computeStats(PokemonFactoryDTO pokemonFactoryDTO) {
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
        .collect(Collectors.toMap(i -> i,
            i -> computeStat(i, pokemonStats.get(i), pokemonFactoryDTO.getStats().get(i + 1), nature)));
  }

  private int computeStat(Integer index, PokemonStat pokemonStat, Integer ev, Nature nature) {
    double natureBonus = getBonusFromNature(index + 1, nature);
    return index == 0 ? getHPFormula(pokemonStat, ev) : getOtherFormula(pokemonStat, ev, natureBonus);
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

  private int getOtherFormula(PokemonStat pokemonStat, int ev, double natureBonus) {
    // Others:  (((IV + 2 * BaseStat + (EV/4) ) * Level/100 ) + 5) * Nature Value
    return (int) (((int) (((2.0 * pokemonStat.getBaseStat() + iv + (ev / 4)) * level) / 100.0) + 5) * natureBonus);
  }

  private int getHPFormula(PokemonStat pokemonStat, int ev) {
    // HP :     (((IV + 2 * BaseStat + (EV/4) ) * Level/100 ) + 10 + Level
    return (int) ((int) (((2.0 * pokemonStat.getBaseStat() + iv + (ev / 4)) * level) / 100.0) + 10 + level);
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setIv(int iv) {
    this.iv = iv;
  }
}
