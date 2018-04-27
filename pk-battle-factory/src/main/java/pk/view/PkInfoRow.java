package pk.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends HorizontalLayout {

  private final PokemonFactoryController pokemonFactoryController;
  private HorizontalLayout rightPanel;
  private TextArea textArea;
  private TextArea statArea;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
  }

  protected void preInit() {
  }

  protected void postInit() {
    textArea = new TextArea();
    textArea.setRows(7);
    textArea.setReadOnly(true);
    textArea.setWidth(20, Unit.EM);

    statArea = new TextArea();
    statArea.setRows(6);
    statArea.setReadOnly(true);
    statArea.setWidth(8, Unit.EM);

    rightPanel = new HorizontalLayout(textArea, statArea);
    rightPanel.setVisible(true);

    addComponent(rightPanel);
  }

  public void showText(PokemonFactoryDTO pokemonFactoryDTO) {
    textArea.setValue(pokemonFactoryDTO.prettyPrint());

    String stats = pokemonFactoryController.printStats(pokemonFactoryDTO);
    statArea.setValue(stats);
  }
}
