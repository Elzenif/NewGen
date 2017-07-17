package pk.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkMoveActionListener;
import pk.controller.PkNameActionListener;
import pk.controller.PkTypeActionListener;
import pk.controller.PokemonFactoryController;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.CardLayout;
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

  private PkNameComboBox nameComboBox;
  private PkTypeComboBox typeComboBox;
  private PkMoveComboBox moveComboBox;

  private JComboBox<PkOpponentCriteria> criteriaComboBox;
  private JPanel leftPanel2;
  private CardLayout leftCardLayout;


  @Autowired
  public PkOpponentInfoRow(PokemonFactoryController pokemonFactoryController, PkNameActionListener pkNameActionListener,
                           PkTypeActionListener pkTypeActionListener, PkMoveActionListener pkMoveActionListener) {
    super(pokemonFactoryController);
    this.pkNameActionListener = pkNameActionListener;
    this.pkTypeActionListener = pkTypeActionListener;
    this.pkMoveActionListener = pkMoveActionListener;
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @Autowired
  public void setTypeComboBox(PkTypeComboBox typeComboBox) {
    this.typeComboBox = typeComboBox;
  }

  @Autowired
  public void setMoveComboBox(PkMoveComboBox moveComboBox) {
    this.moveComboBox = moveComboBox;
  }

  @PostConstruct
  public void init() {
    preInit();

    criteriaComboBox = new JComboBox<>(PkOpponentCriteria.values());
    add(criteriaComboBox);

    leftPanel2 = new JPanel();
    leftCardLayout = new CardLayout();
    leftPanel2.setLayout(leftCardLayout);

    nameComboBox.setEditable(true);
    leftPanel2.add(PkOpponentCriteria.NAME.getName(), nameComboBox);

    typeComboBox.setEditable(true);
    leftPanel2.add(PkOpponentCriteria.TYPE.getName(), typeComboBox);

    moveComboBox.setEditable(true);
    leftPanel2.add(PkOpponentCriteria.MOVE.getName(), moveComboBox);

    leftCardLayout.show(leftPanel2, PkOpponentCriteria.NAME.getName());
    add(leftPanel2);

    criteriaComboBox.addActionListener(new PkOpponentCriteriaActionListener());
    nameComboBox.addActionListener(pkNameActionListener);
    typeComboBox.addActionListener(pkTypeActionListener);
    moveComboBox.addActionListener(pkMoveActionListener);

    postInit();
  }

  private class PkOpponentCriteriaActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      leftCardLayout.show(leftPanel2, ((PkOpponentCriteria) criteriaComboBox.getSelectedItem()).getName());
    }
  }
}
