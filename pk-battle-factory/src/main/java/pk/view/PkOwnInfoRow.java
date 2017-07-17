package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameActionListener;
import pk.controller.PokemonFactoryController;

import javax.annotation.PostConstruct;
import javax.swing.JLabel;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOwnInfoRow extends PkInfoRow {

  private final PkNameActionListener pkNameActionListener;

  private PkNameComboBox nameComboBox;


  @Autowired
  public PkOwnInfoRow(PokemonFactoryController pokemonFactoryController, PkNameActionListener pkNameActionListener) {
    super(pokemonFactoryController);
    this.pkNameActionListener = pkNameActionListener;
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @PostConstruct
  public void init() {
    preInit();

    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    add(name);

    nameComboBox.setEditable(true);
    add(nameComboBox);

    nameComboBox.addActionListener(pkNameActionListener);

    postInit();
  }
}
