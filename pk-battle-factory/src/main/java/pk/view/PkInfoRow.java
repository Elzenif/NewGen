package pk.view;

import commons.Constants;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.FlowLayout;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends JPanel {

  private final PokemonFactoryController pokemonFactoryController;
  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JTextArea textArea;
  private JTextArea statArea;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, 1));
  }

  protected void preInit() {
  }

  protected void postInit() {
    rightPanel = new JPanel();
    cardLayout = new CardLayout();
    rightPanel.setLayout(cardLayout);

    JLabel label = new JLabel();
    rightPanel.add("false", label);

    JPanel areasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP * 2, 0));
    textArea = new JTextArea();
    textArea.setOpaque(false);
    textArea.setRows(7);
    areasPanel.add(textArea);
    statArea = new JTextArea();
    statArea.setOpaque(false);
    statArea.setRows(6);
    areasPanel.add(statArea);
    rightPanel.add("true", areasPanel);

    cardLayout.show(rightPanel, "false");

    add(rightPanel);
  }

  public void showText(PokemonFactoryDTO pokemonFactoryDTO) {
    textArea.setText(pokemonFactoryDTO.prettyPrint());
    String stats = pokemonFactoryController.printStats(pokemonFactoryDTO);
    statArea.setText(stats);
    cardLayout.show(rightPanel, "true");
  }
}
