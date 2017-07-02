package pk.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pk.model.repository.PokemonSpeciesNameRepository;

/**
 * Created by Germain on 02/07/2017.
 */
@Configuration
public class ViewConfiguration {

  @Bean
  public PkInfoRow pkInfoRow1(PokemonSpeciesNameRepository pokemonSpeciesNameRepository) {
    return new PkInfoRow(pokemonSpeciesNameRepository);
  }

  @Bean
  public PkInfoRow pkInfoRow2(PokemonSpeciesNameRepository pokemonSpeciesNameRepository) {
    return new PkInfoRow(pokemonSpeciesNameRepository);
  }

  @Bean
  public PkInfoRow pkInfoRow3(PokemonSpeciesNameRepository pokemonSpeciesNameRepository) {
    return new PkInfoRow(pokemonSpeciesNameRepository);
  }
}
