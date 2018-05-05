package pk.view.main;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.model.entity.TypeName;
import pk.view.model.PkTypeComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkTypeComboBox extends PkComboBox<TypeName> {

  @Autowired
  public PkTypeComboBox(PkTypeComboBoxModel pkTypeComboBoxModel) {
    super(pkTypeComboBoxModel, Constants.resourceBundle.getString("type"));
  }
}
