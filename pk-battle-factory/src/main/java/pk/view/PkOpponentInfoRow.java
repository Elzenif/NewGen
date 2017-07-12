package pk.view;

import commons.Constants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkMoveActionListener;
import pk.controller.PkNameActionListener;
import pk.controller.PkTypeActionListener;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 10/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOpponentInfoRow extends PkInfoRow {

  private final PkNameActionListener pkNameActionListener;
  private final PkTypeActionListener pkTypeActionListener;
  private final PkMoveActionListener pkMoveActionListener;
  private final OptionMenu optionMenu;

  private JPanel leftPanel;
  private JComboBox<PkOpponentCriteria> criteriaComboBox;
  private JPanel leftPanel2;
  private CardLayout leftCardLayout;
  private JComboBox<Object> nameComboBox;
  private JComboBox<Object> typeComboBox;
  private JComboBox<Object> moveComboBox;

  private JPanel rightPanel;


  @Autowired
  public PkOpponentInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                           TypeNameRepository typeNameRepository, MoveNameRepository moveNameRepository,
                           PkNameActionListener pkNameActionListener, PkTypeActionListener pkTypeActionListener,
                           PkMoveActionListener pkMoveActionListener, OptionMenu optionMenu) {
    super(pokemonSpeciesNameRepository, typeNameRepository, moveNameRepository);
    this.pkNameActionListener = pkNameActionListener;
    this.pkTypeActionListener = pkTypeActionListener;
    this.pkMoveActionListener = pkMoveActionListener;
    this.optionMenu = optionMenu;
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }


  @PostConstruct
  public void init() {
    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    criteriaComboBox = new JComboBox<>(PkOpponentCriteria.values());
    leftPanel.add(criteriaComboBox);

    leftPanel2 = new JPanel();
    leftCardLayout = new CardLayout();
    leftPanel2.setLayout(leftCardLayout);

    nameComboBox = new JComboBox<>(getAllPokemonSpeciesNames(1, optionMenu.getSelectedGeneration()));
    AutoCompleteDecorator.decorate(nameComboBox);
    leftPanel2.add(PkOpponentCriteria.NAME.getName(), nameComboBox);

    typeComboBox = new JComboBox<>(getAllTypeNames(1, optionMenu.getSelectedGeneration()));
    AutoCompleteDecorator.decorate(typeComboBox);
    leftPanel2.add(PkOpponentCriteria.TYPE.getName(), typeComboBox);

    moveComboBox = new JComboBox<>(getAllMoveNames(1, optionMenu.getSelectedGeneration()));
    AutoCompleteDecorator.decorate(moveComboBox);
    leftPanel2.add(PkOpponentCriteria.MOVE.getName(), moveComboBox);

    leftCardLayout.show(leftPanel2, PkOpponentCriteria.NAME.getName());
    leftPanel.add(leftPanel2);

    rightPanel = new JPanel();

    add(leftPanel);
    add(rightPanel);

    comboBoxMap.put(nameComboBox, this::getAllPokemonSpeciesNames);
    comboBoxMap.put(typeComboBox, this::getAllTypeNames);
    comboBoxMap.put(moveComboBox, this::getAllMoveNames);

    criteriaComboBox.addActionListener(new PkOpponentCriteriaActionListener());
    nameComboBox.addActionListener(pkNameActionListener);
    typeComboBox.addActionListener(pkTypeActionListener);
    moveComboBox.addActionListener(pkMoveActionListener);

    optionMenu.addPkGenerationAware(this);
  }

  private class PkOpponentCriteriaActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      leftCardLayout.show(leftPanel2, ((PkOpponentCriteria) criteriaComboBox.getSelectedItem()).getName());
    }
  }
}
