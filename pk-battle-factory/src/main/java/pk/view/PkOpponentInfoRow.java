package pk.view;

import commons.Constants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameActionListener;
import pk.model.entity.PokemonSpeciesName;
import pk.model.repository.PokemonSpeciesNameRepository;

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
  private final PkNameActionListener pkNameActionListener;

  private JPanel leftPanel;
  private JComboBox<PkOpponentCriteria> criteriaComboBox;
  private JPanel leftPanel2;
  private CardLayout leftCardLayout;
  private JComboBox nameComboBox;
  private JComboBox typeComboBox;

  private JPanel rightPanel;


  @Autowired
  public PkOpponentInfoRow(PokemonSpeciesNameRepository pokemonSpeciesNameRepository,
                           PkNameActionListener pkNameActionListener) {
    this.pokemonSpeciesNameRepository = pokemonSpeciesNameRepository;
    this.pkNameActionListener = pkNameActionListener;
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
    List<PokemonSpeciesName> pokemonSpeciesNames = pokemonSpeciesNameRepository.findAllByLanguage(language);
    Object[] names = pokemonSpeciesNames.stream().map(PokemonSpeciesName::getName).toArray();
    nameComboBox = new JComboBox<>(names);
    AutoCompleteDecorator.decorate(nameComboBox);
    leftPanel2.add(PkOpponentCriteria.NAME.getName(), nameComboBox);

    typeComboBox = new JComboBox<>(new String[]{"eau", "feu"});
    AutoCompleteDecorator.decorate(typeComboBox);
    leftPanel2.add(PkOpponentCriteria.TYPE.getName(), typeComboBox);

    leftCardLayout.show(leftPanel2, PkOpponentCriteria.NAME.getName());
    leftPanel.add(leftPanel2);

    rightPanel = new JPanel();

    add(leftPanel);
    add(rightPanel);

    criteriaComboBox.addActionListener(new PkOpponentCriteriaActionListener());
    nameComboBox.addActionListener(pkNameActionListener);
  }

  private class PkOpponentCriteriaActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      leftCardLayout.show(leftPanel2, ((PkOpponentCriteria) criteriaComboBox.getSelectedItem()).getName());
    }
  }
}
