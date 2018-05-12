package pk.view.helper;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.utils.PkImage;

import java.util.Set;

@Component
public class ResultPanel extends Panel {

  private final HelperModel helperModel;
  private GridLayout gridLayout = new GridLayout(4, 7);

  @Autowired
  public ResultPanel(HelperModel helperModel) {
    this.helperModel = helperModel;

    setContent(gridLayout);
  }

  public void refresh() {
    Set<PokemonFactoryDTO> ownPokemons = helperModel.getOwnPokemons();
    Set<PokemonFactoryDTO> opponentPokemons = helperModel.getOpponentPokemons();

    gridLayout = new GridLayout();
    gridLayout.setColumns(opponentPokemons.size() + 1);
    gridLayout.setRows(ownPokemons.size() + 1);

    int i = 1;
    for (PokemonFactoryDTO ownPokemon : ownPokemons) {
      gridLayout.addComponent(PkImage.of(ownPokemon), 0, i);
      i++;
    }

    int j = 1;
    for (PokemonFactoryDTO opponentPokemon : opponentPokemons) {
      gridLayout.addComponent(PkImage.of(opponentPokemon), j, 0);
      j++;
    }

    gridLayout.setHeight(100f, Unit.PERCENTAGE);
    gridLayout.setWidth(100f, Unit.PERCENTAGE);
    setContent(gridLayout);
  }

}
