package pk.view.helper;

import com.vaadin.ui.GridLayout;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;

import java.util.Set;

@Component
public class TypeInfoPanel extends GridLayout {

  private final HelperModel helperModel;
//  private final TypeRepository typeRepository;

  public TypeInfoPanel(HelperModel helperModel) {
    this.helperModel = helperModel;

  }

  public void refresh() {
    // Types I'm weak to
    // -> intersection of weaknesses of my team

    // Types I'm neutral to
    // -> intersection of neutral resistances of my team

    // Types I'm resisting to
    // -> intersection of resistances of my team

    // OR

    // Grid of my pokemons in each row and all the types in each column
    // In each cell, the multiplier of damage I take + color code (x4, x2, x1, x0.5, x0.25, x0)
    // Total weakness/neutral/resistance row with global multiplier (up to x64 for 3 pokemon team)
    // Bonus -> hovering each cell gives you the potential attack from the opponent team + the damage calc for the given pokemon
    Set<PokemonFactoryDTO> ownPokemons = helperModel.getOwnPokemons();

  }
}
