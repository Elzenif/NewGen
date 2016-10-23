package commons.view.entity.items;

import commons.controller.entity.EntityController;
import commons.controller.entity.items.ItemController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.model.entity.items.IAvailableItem;
import commons.utils.TextFieldUtils;
import commons.view.entity.EntityOptionRow;
import commons.view.utils.ConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.text.MessageFormat;
import java.util.EnumSet;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemOptionRow<G extends Game> extends EntityOptionRow<G> {

  private final ConstraintPanel qualityPanel;
  private final JFormattedTextField qualityTextField;

  protected ItemOptionRow(IAvailableEntity<G> availableItem, EnumSet<? extends IAvailableItem<G>> availableItems) {
    super(availableItem, availableItems);

    // quality constraints
    qualityTextField = TextFieldUtils.createTwoDigitsField();
    qualityTextField.setToolTipText(MessageFormat.format(resourceBundle.getString("tooltip.entity.qualityTextField"), name));
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));
    qualityPanel.add(qualityTextField);
    constraintPanel.add(qualityPanel);
  }

  public JFormattedTextField getQualityTextField() {
    return qualityTextField;
  }


  @Override
  protected void setControllers(EntityController<G> entityController) {
    super.setControllers(entityController);
    qualityTextField.addPropertyChangeListener(((ItemController) controller).getRarityChangeListener());
  }
}
