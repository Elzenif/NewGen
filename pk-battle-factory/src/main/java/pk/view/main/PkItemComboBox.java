package pk.view.main;

import commons.Constants;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.model.entity.ItemName;
import pk.view.model.PkItemComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkItemComboBox extends PkComboBox<ItemName> {

  public PkItemComboBox(PkItemComboBoxModel originalComboBoxModel) {
    super(originalComboBoxModel, Constants.resourceBundle.getString("item"));
  }
}
