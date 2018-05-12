package pk.model.data;

import commons.utils.Pair;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;

import java.util.Set;

@Component
public class HelperModel {

  private Set<PokemonFactoryDTO> ownPokemons;
  private Set<PokemonFactoryDTO> opponentPokemons;

  public void compute(Pair<Set<PokemonFactoryDTO>, Set<PokemonFactoryDTO>> selectedPokemons) {
    this.ownPokemons = selectedPokemons.getLeft();
    this.opponentPokemons = selectedPokemons.getRight();
  }

  public Set<PokemonFactoryDTO> getOwnPokemons() {
    return ownPokemons;
  }

  public Set<PokemonFactoryDTO> getOpponentPokemons() {
    return opponentPokemons;
  }
}
