package pk.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
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
  private Label label;
  private HorizontalLayout areasPanel;
  private Component currentComponent;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
  }

  protected void preInit() {
  }

  protected void postInit() {
    rightPanel = new HorizontalLayout();

    label = new Label();
    rightPanel.addComponent(label);

    currentComponent = label;

    areasPanel = new HorizontalLayout();
    textArea = new TextArea();
//    textArea.setOpaque(false);
    textArea.setRows(7);
    areasPanel.addComponent(textArea);
    statArea = new TextArea();
//    statArea.setOpaque(false);
    statArea.setRows(6);
    areasPanel.addComponent(statArea);

//    rightPanel.setContent(areasPanel);

    addComponent(rightPanel);
  }

  public void showText(PokemonFactoryDTO pokemonFactoryDTO) {
    textArea.setValue(pokemonFactoryDTO.prettyPrint());
    String stats = pokemonFactoryController.printStats(pokemonFactoryDTO);
    statArea.setValue(stats);

    rightPanel.replaceComponent(currentComponent, areasPanel);
    currentComponent = areasPanel;
  }
}
