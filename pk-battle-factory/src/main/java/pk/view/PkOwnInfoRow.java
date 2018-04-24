package pk.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameValueChangeListener;
import pk.controller.PokemonFactoryController;

import javax.annotation.PostConstruct;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOwnInfoRow extends PkInfoRow {

  private final PkNameValueChangeListener pkNameValueChangeListener;

  private PkNameComboBox nameComboBox;


  @Autowired
  public PkOwnInfoRow(PokemonFactoryController pokemonFactoryController, PkNameValueChangeListener pkNameValueChangeListener) {
    super(pokemonFactoryController);
    this.pkNameValueChangeListener = pkNameValueChangeListener;
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @PostConstruct
  public void init() {
    preInit();

    addComponent(nameComboBox);

    nameComboBox.addValueChangeListener(pkNameValueChangeListener);

    postInit();
  }
}
