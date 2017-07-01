package pk.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pk.model.repository.PokemonSpeciesNamesRepository;

/**
 * Created by Germain on 02/07/2017.
 */
@Configuration
public class ViewConfiguration {

  @Bean
  public PkInfoRow pkInfoRow1(PokemonSpeciesNamesRepository pokemonSpeciesNamesRepository) {
    return new PkInfoRow(pokemonSpeciesNamesRepository);
  }

  @Bean
  public PkInfoRow pkInfoRow2(PokemonSpeciesNamesRepository pokemonSpeciesNamesRepository) {
    return new PkInfoRow(pokemonSpeciesNamesRepository);
  }

  @Bean
  public PkInfoRow pkInfoRow3(PokemonSpeciesNamesRepository pokemonSpeciesNamesRepository) {
    return new PkInfoRow(pokemonSpeciesNamesRepository);
  }
}
