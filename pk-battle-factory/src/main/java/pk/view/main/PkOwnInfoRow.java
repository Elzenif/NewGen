package pk.view.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameValueChangeListener;
import pk.controller.PokemonFactoryController;
import pk.model.data.OwnPokemonRowModel;

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
  public PkOwnInfoRow(PokemonFactoryController pokemonFactoryController, OwnPokemonRowModel ownPokemonRowModel,
                      PkNameValueChangeListener pkNameValueChangeListener) {
    super(pokemonFactoryController, ownPokemonRowModel);
    this.pkNameValueChangeListener = pkNameValueChangeListener;
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @PostConstruct
  public void init() {
    addComponent(nameComboBox);

    nameComboBox.addValueChangeListener(pkNameValueChangeListener);

    postInit();
  }
}
