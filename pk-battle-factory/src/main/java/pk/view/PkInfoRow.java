package pk.view;

import commons.Constants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.model.entity.PokemonSpeciesNames;
import pk.model.repository.PokemonSpeciesNamesRepository;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PkInfoRow extends JPanel {

  private final PokemonSpeciesNamesRepository pokemonSpeciesNamesRepository;

  private JPanel leftPanel;
  private JComboBox nameComboBox;
  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JLabel label;
  private JTextPane textPane;

  @Autowired
  public PkInfoRow(PokemonSpeciesNamesRepository pokemonSpeciesNamesRepository) {
    this.pokemonSpeciesNamesRepository = pokemonSpeciesNamesRepository;
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }
  
  @PostConstruct
  public void init() {
    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    leftPanel.add(name);
    List<PokemonSpeciesNames> pokemonSpeciesNames = pokemonSpeciesNamesRepository.findAllByIdLocalLanguageId(5);
    Object[] names = pokemonSpeciesNames.stream().map(PokemonSpeciesNames::getName).toArray();
    nameComboBox = new JComboBox(names);
    AutoCompleteDecorator.decorate(nameComboBox);
    leftPanel.add(nameComboBox);

    rightPanel = new JPanel();
    cardLayout = new CardLayout();
    rightPanel.setLayout(cardLayout);
    label = new JLabel();
    rightPanel.add("false", label);
    textPane = new JTextPane();
    rightPanel.add("true", textPane);
    cardLayout.show(rightPanel, "false");

    add(leftPanel);
    add(rightPanel);
  }

  public JLabel getLabel() {
    return label;
  }

  public JTextPane getTextPane() {
    return textPane;
  }
}
