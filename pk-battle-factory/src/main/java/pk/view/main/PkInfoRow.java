package pk.view.main;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pk.controller.PokemonFactoryController;
import pk.model.data.PokemonModel;
import pk.model.dto.PokemonFactoryDTO;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends HorizontalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoRow.class);
  private final PokemonFactoryController pokemonFactoryController;
  private final PokemonModel pokemonModel;
  private TextArea textArea;
  private TextArea statArea;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController, PokemonModel pokemonModel) {
    setId(UUID.randomUUID().toString());
    this.pokemonFactoryController = pokemonFactoryController;
    this.pokemonModel = pokemonModel;
  }

  protected void postInit() {
    textArea = new TextArea();
    textArea.setRows(7);
    textArea.setReadOnly(true);
    textArea.setWidth(20, Unit.EM);
    addComponent(textArea);

    statArea = new TextArea();
    statArea.setRows(6);
    statArea.setReadOnly(true);
    statArea.setWidth(8, Unit.EM);
    addComponent(statArea);
  }

  public void updatePokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    pokemonModel.put(this, pokemonFactoryDTO);
  }

  public void refresh() {
    if (pokemonModel.hasOnePokemon(this)) {
      PokemonFactoryDTO pokemonFactoryDTO = pokemonModel.get(this);

      LOGGER.debug(String.format("Refreshing %s", pokemonFactoryDTO));
      textArea.setValue(pokemonFactoryDTO.prettyPrint());

      Map<Integer, Integer> stats = pokemonFactoryController.computeStats(pokemonFactoryDTO);

      String printedStats = pokemonFactoryController.printStats(stats);
      statArea.setValue(printedStats);
    }
  }

}
