package pk.view.main;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pk.controller.PokemonFactoryController;
import pk.model.data.PokemonRowModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.utils.PkImage;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends HorizontalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoRow.class);
  private final PokemonFactoryController pokemonFactoryController;
  private final PokemonRowModel pokemonRowModel;
  private PkImage pkImage;
  private TextArea textArea;
  private TextArea statArea;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController, PokemonRowModel pokemonRowModel) {
    setId(UUID.randomUUID().toString());
    this.pokemonFactoryController = pokemonFactoryController;
    this.pokemonRowModel = pokemonRowModel;
  }

  protected void postInit() {
    pkImage = PkImage.empty();
    addComponent(pkImage);

    textArea = new TextArea();
    textArea.setRows(7);
    textArea.setReadOnly(true);
    textArea.setWidth(20, Unit.EM);
    textArea.setVisible(false);
    addComponent(textArea);

    statArea = new TextArea();
    statArea.setRows(6);
    statArea.setReadOnly(true);
    statArea.setWidth(8, Unit.EM);
    statArea.setVisible(false);
    addComponent(statArea);
  }

  public void updatePokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    pokemonRowModel.put(this, pokemonFactoryDTO);
  }

  public void refresh() {
    if (pokemonRowModel.hasOnePokemon(this)) {
      PokemonFactoryDTO pokemonFactoryDTO = pokemonRowModel.get(this);
      LOGGER.debug(String.format("Refreshing %s", pokemonFactoryDTO));

      PkImage newImage = PkImage.of(pokemonFactoryDTO);
      replaceComponent(pkImage, newImage);
      pkImage = newImage;

      textArea.setValue(pokemonFactoryDTO.prettyPrint());
      textArea.setVisible(true);

      Map<Integer, Integer> stats = pokemonFactoryController.computeStats(pokemonFactoryDTO);

      String printedStats = pokemonFactoryController.printStats(stats);
      statArea.setValue(printedStats);
      statArea.setVisible(true);
    }
  }

}
