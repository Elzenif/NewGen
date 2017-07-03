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
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;

import java.util.List;
import java.util.Locale;

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

  @Test
  public void loadContext() {
  }

  @Test
  public void testFindAllByLanguage() {
    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository.findAllByLanguage(language);
    assertThat(pokemonSpeciesNames).hasSize(721);
  }

  @Test
  public void testFindPokemonFactoryByName() {
    List<PokemonFactoryDTO> pokemonFactoryDTOS = pokemonFactoryController.findByName("Raichu");
    for (PokemonFactoryDTO pokemonFactoryDTO : pokemonFactoryDTOS) {
      LOGGER.info("Found " + pokemonFactoryDTO.toString());
    }
    assertThat(pokemonFactoryDTOS).hasSize(4);
  }
}
