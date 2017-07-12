package pk.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.view.model.PokemonSpeciesNamesComboBoxModel;
import pk.view.model.SharedComboBoxModel;

import javax.swing.JComboBox;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkNameComboBox extends JComboBox<Object> {

  @Autowired
  public PkNameComboBox(PokemonSpeciesNamesComboBoxModel pokemonSpeciesNamesComboBoxModel) {
    setModel(new SharedComboBoxModel(pokemonSpeciesNamesComboBoxModel));
  }
}
