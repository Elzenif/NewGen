package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.model.entity.NatureName;
import pk.view.model.PkNatureComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkNatureComboBox extends PkComboBox<NatureName> {

  @Autowired
  public PkNatureComboBox(PkNatureComboBoxModel originalComboBoxModel) {
    super(originalComboBoxModel, Constants.resourceBundle.getString("nature"));
  }
}
