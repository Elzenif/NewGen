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
import pk.model.entity.MoveName;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.TypeName;
import pk.model.repository.MoveNameRepository;
import pk.model.repository.PokemonSpeciesNameRepository;
import pk.model.repository.TypeNameRepository;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

/**
 * Created by Germain on 10/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOpponentInfoRow extends JPanel {

  private final PokemonSpeciesNameRepository pokemonSpeciesNameRepository;
  private final TypeNameRepository typeNameRepository;
  private final MoveNameRepository moveNameRepository;
  private final PkNameActionListener pkNameActionListener;
  private final PkTypeActionListener pkTypeActionListener;
  private final PkMoveActionListener pkMoveActionListener;

  private JPanel leftPanel;
  private JComboBox<PkOpponentCriteria> criteriaComboBox;
  private JPanel leftPanel2;
  private CardLayout leftCardLayout;
  private JComboBox nameComboBox;
  private JComboBox typeComboBox;
  private JComboBox moveComboBox;

  private JPanel rightPanel;


  @Autowired
  public PkOpponentInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                           TypeNameRepository typeNameRepository, MoveNameRepository moveNameRepository,
                           PkNameActionListener pkNameActionListener, PkTypeActionListener pkTypeActionListener,
                           PkMoveActionListener pkMoveActionListener) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.typeNameRepository = typeNameRepository;
    this.moveNameRepository = moveNameRepository;
    this.pkNameActionListener = pkNameActionListener;
    this.pkTypeActionListener = pkTypeActionListener;
    this.pkMoveActionListener = pkMoveActionListener;
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

    String language = Locale.getDefault().getLanguage();
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository
        .findAllByLanguageAndGenerationMax(language, 4);
    Object[] names = pokemonSpeciesNames.stream().map(PokemonSpeciesName::getName).toArray();
    nameComboBox = new JComboBox<>(names);
    AutoCompleteDecorator.decorate(nameComboBox);
    leftPanel2.add(PkOpponentCriteria.NAME.getName(), nameComboBox);

    List<TypeName> typeNames = typeNameRepository.findAllByLanguage(language, 4);
    Object[] types = typeNames.stream().map(TypeName::getName).toArray();
    typeComboBox = new JComboBox<>(types);
    AutoCompleteDecorator.decorate(typeComboBox);
    leftPanel2.add(PkOpponentCriteria.TYPE.getName(), typeComboBox);

    List<MoveName> moveNames = moveNameRepository.findAllByLanguage(language, 4);
    Object[] moves = moveNames.stream().map(MoveName::getName).toArray();
    moveComboBox = new JComboBox<>(moves);
    AutoCompleteDecorator.decorate(moveComboBox);
    leftPanel2.add(PkOpponentCriteria.MOVE.getName(), moveComboBox);

    leftCardLayout.show(leftPanel2, PkOpponentCriteria.NAME.getName());
    leftPanel.add(leftPanel2);

    rightPanel = new JPanel();

    add(leftPanel);
    add(rightPanel);

    criteriaComboBox.addActionListener(new PkOpponentCriteriaActionListener());
    nameComboBox.addActionListener(pkNameActionListener);
    typeComboBox.addActionListener(pkTypeActionListener);
    moveComboBox.addActionListener(pkMoveActionListener);
  }

  private class PkOpponentCriteriaActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      leftCardLayout.show(leftPanel2, ((PkOpponentCriteria) criteriaComboBox.getSelectedItem()).getName());
    }
  }
}
