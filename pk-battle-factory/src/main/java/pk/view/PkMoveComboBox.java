package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.model.entity.MoveName;
import pk.view.model.PkMoveComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkMoveComboBox extends PkComboBox<MoveName> {

  @Autowired
  public PkMoveComboBox(PkMoveComboBoxModel pkMoveComboBoxModel) {
    super(pkMoveComboBoxModel, Constants.resourceBundle.getString("name"));
  }
}
