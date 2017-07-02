package pk.view;

import commons.Constants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PkNameActionListener;
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Locale;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkInfoRow extends JPanel {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final PkNameActionListener pkNameActionListener;

  private JPanel leftPanel;
  private JComboBox nameComboBox;
  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JLabel label;
  private JTextPane textPane;

  @Autowired
  public PkInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                   PkNameActionListener pkNameActionListener) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.pkNameActionListener = pkNameActionListener;
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }
  
  @PostConstruct
  public void init() {
    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    leftPanel.add(name);
    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository.findAllByLanguage(language);
    Object[] names = pokemonSpeciesNames.stream().map(PokemonSpeciesName::getName).toArray();
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

    nameComboBox.addActionListener(pkNameActionListener);
  }

  public JLabel getLabel() {
    return label;
  }

  public JTextPane getTextPane() {
    return textPane;
  }
}
