package pk.view.helper;

import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import pk.model.dto.PokemonFactoryDTO;

import java.util.Set;

public class OpponentResultPanel extends ResultPanel {

  @Override
  public OpponentResultPanel refresh(CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup, GridLayout gridLayout) {
    Set<PokemonFactoryDTO> pokemons = checkBoxGroup.getSelectedItems();

    /*
     * Useful info?
     * List duels between each pair of pokemon
     * Colour code for easy winner, tough match up, balanced match up, to difficult to judge
     * In tooltip ->
     *   Damage calculation range of each attack
     *   Possibility of OHKO, 2 OHKO, etc...
     */

    OpponentResultPanel newResultPanel = new OpponentResultPanel();
    for (PokemonFactoryDTO pokemon : pokemons) {
      newResultPanel.addComponent(new Label(pokemon.getPkName()));
    }

    gridLayout.replaceComponent(this, newResultPanel);
    return newResultPanel;
  }
}