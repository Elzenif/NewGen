package pk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pk.model.entity.PokemonSpeciesName;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.PokemonFactoryRepository;
import pk.model.repository.PokemonSpeciesNameRepository;

import java.util.List;
import java.util.Locale;

/**
 * Created by Germain on 02/07/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PkApplication.class, loader = CustomSpringBootContextLoader.class)
public class PkApplicationTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkApplicationTest.class);

  @Autowired
  private PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  @Autowired
  private PokemonFactoryRepository pokemonFactoryRepository;

  @Test
  public void loadContext() {
    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository.findAllByLanguage(language);
    String found = "Found " + pokemonSpeciesNames.size();
    LOGGER.info(found);

    List<PokemonFactoryProjection> projectionList = pokemonFactoryRepository.find("Raichu", language);
    for (PokemonFactoryProjection pokemonFactoryProjection : projectionList) {
      LOGGER.info("Found " + pokemonFactoryProjection.getString());
    }
  }
}
