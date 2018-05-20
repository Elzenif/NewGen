package pk.view.helper;

import com.vaadin.ui.GridLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.utils.PkImage;

import java.util.Set;

@Component
public class ResultPanel extends GridLayout {

  private final HelperModel helperModel;

  @Autowired
  public ResultPanel(HelperModel helperModel) {
    super(4, 7);
    this.helperModel = helperModel;
  }

  public void refresh() {
    Set<PokemonFactoryDTO> ownPokemons = helperModel.getOwnPokemons();
    Set<PokemonFactoryDTO> opponentPokemons = helperModel.getOpponentPokemons();

    removeAllComponents();
    setColumns(opponentPokemons.size() + 1);
    setRows(ownPokemons.size() + 1);

    int i = 1;
    for (PokemonFactoryDTO ownPokemon : ownPokemons) {
      addComponent(PkImage.of(ownPokemon), 0, i);
      i++;
    }

    int j = 1;
    for (PokemonFactoryDTO opponentPokemon : opponentPokemons) {
      addComponent(PkImage.of(opponentPokemon), j, 0);
      j++;
    }

    /*
     * Useful info?
     * List duels between each pair of pokemon
     * Colour code for easy winner, tough match up, balanced match up, to difficult to judge
     * In tooltip ->
     *   Damage calculation range of each attack
     *   Possibility of OHKO, 2 OHKO, etc...
     *   Speed ratio
     */

    setHeight(100f, Unit.PERCENTAGE);
    setWidth(100f, Unit.PERCENTAGE);
  }

}
