package pk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.MoveName;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.TypeName;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 02/07/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PkApplication.class, loader = CustomSpringBootContextLoader.class)
public class PkApplicationTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkApplicationTest.class);

  @Autowired
  private PokemonFactoryController pokemonFactoryController;
  @Autowired
  private PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  @Autowired
  private MoveNameRepository moveNameRepository;
  @Autowired
  private TypeNameRepository typeNameRepository;

  @Test
  public void loadContext() {
  }

  @Test
  public void testFindAllByLanguage() {
    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository
        .findAllByLanguageAndGeneration(language, 6);
    assertThat(pokemonSpeciesNames).hasSize(721);
  }

  @Test
  public void testFindPokemonFactoryByName() {
    List<PokemonFactoryDTO> pokemonFactoryDTOS = pokemonFactoryController.findByName("Raichu")
        .collect(Collectors.toList());
    for (PokemonFactoryDTO pokemonFactoryDTO : pokemonFactoryDTOS) {
      LOGGER.info("Found " + pokemonFactoryDTO.toString());
    }
    assertThat(pokemonFactoryDTOS).hasSize(4);
  }

  @Test
  public void testFindAllMovesByGeneration() {
    String language = Locale.getDefault().getLanguage();
    List<MoveName> moveNames = moveNameRepository.findAllByLanguage(language, 4);
    assertThat(moveNames).hasSize(485);
  }

  @Test
  public void testFindAllTypes() {
    String language = Locale.getDefault().getLanguage();
    List<TypeName> typeNames = typeNameRepository.findAllByLanguage(language, 4);
    assertThat(typeNames).hasSize(17);
    assertThat(typeNames).extracting("name").doesNotContain("Fairy", "Fée");
  }
}
