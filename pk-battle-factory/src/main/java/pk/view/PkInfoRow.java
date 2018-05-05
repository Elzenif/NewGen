package pk.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

import java.util.Map;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends HorizontalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoRow.class);
  private final PokemonFactoryController pokemonFactoryController;
  private TextArea textArea;
  private TextArea statArea;
  private PokemonFactoryDTO pokemonFactoryDTO;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
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

  public void showText(PokemonFactoryDTO pokemonFactoryDTO) {
    this.pokemonFactoryDTO = pokemonFactoryDTO;
    refresh();
  }

  public void refresh() {
    if (pokemonFactoryDTO != null && pokemonFactoryDTO.getId() != null) {
      LOGGER.debug(String.format("Refreshing %s", pokemonFactoryDTO));
      textArea.setValue(pokemonFactoryDTO.prettyPrint());

      Map<Integer, Integer> stats = pokemonFactoryController.computeStats(pokemonFactoryDTO);

      String printedStats = pokemonFactoryController.printStats(stats);
      statArea.setValue(printedStats);
    }
  }

  @NotNull
  public PokemonFactoryDTO getPokemonFactoryDTO() {
    if (pokemonFactoryDTO == null) {
      pokemonFactoryDTO = new PokemonFactoryDTO();
    }
    return pokemonFactoryDTO;
  }
}
