package pk.view;

import commons.Constants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameActionListener;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOwnInfoRow extends PkInfoRow implements PkGenerationAware {

  private final PkNameActionListener pkNameActionListener;
  private final OptionMenu optionMenu;

  private JPanel leftPanel;
  private JComboBox<Object> nameComboBox;
  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JLabel label;
  private JTextPane textPane;

  @Autowired
  public PkOwnInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository, TypeNameRepository typeNameRepository,
                      MoveNameRepository moveNameRepository, PkNameActionListener pkNameActionListener,
                      OptionMenu optionMenu) {
    super(pokemonSpeciesNameRepository, typeNameRepository, moveNameRepository);
    this.pkNameActionListener = pkNameActionListener;
    this.optionMenu = optionMenu;
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }
  
  @PostConstruct
  public void init() {
    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    leftPanel.add(name);
    nameComboBox = new JComboBox<>(getAllPokemonSpeciesNames(1, optionMenu.getSelectedGeneration()));
    nameComboBox.setEditable(true);
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

    optionMenu.addPkGenerationAware(this);
  }

  public JLabel getLabel() {
    return label;
  }

  public JTextPane getTextPane() {
    return textPane;
  }

  @Override
  public void updateGeneration(int oldGeneration, int newGeneration) {
    if (oldGeneration > newGeneration) {
      for (Object name : getAllPokemonSpeciesNames(newGeneration + 1, oldGeneration)) {
        nameComboBox.removeItem(name);
      }
    } else if (oldGeneration < newGeneration) {
      for (Object name : getAllPokemonSpeciesNames(oldGeneration + 1, newGeneration)) {
        nameComboBox.addItem(name);
      }
    }
  }
}
