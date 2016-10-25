package commons.view.entity.items;

import commons.controller.entity.EntityController;
import commons.controller.entity.items.ItemController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.model.entity.items.IAvailableItem;
import commons.view.entity.EntityOptionRow;
import commons.view.utils.ConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.MessageFormat;
import java.util.EnumSet;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemOptionRow<G extends Game> extends EntityOptionRow<G> {

  private final ConstraintPanel qualityPanel;
  private final JLabel qualityLabel;
  private final SpinnerNumberModel qualityNumberModel;
  private final JSpinner qualitySpinner;

  protected ItemOptionRow(IAvailableEntity<G> availableItem, EnumSet<? extends IAvailableItem<G>> availableItems) {
    super(availableItem, availableItems);

    // quality constraints
    qualityPanel = new ConstraintPanel();
    qualityPanel.setLayout(new BoxLayout(qualityPanel, BoxLayout.Y_AXIS));

    qualityLabel = new JLabel("D100");
    qualityLabel.setAlignmentX(LEFT_ALIGNMENT);

    qualityNumberModel = new SpinnerNumberModel(50, 1, 100, 1);
    qualitySpinner = new JSpinner(qualityNumberModel);
    qualitySpinner.setToolTipText(MessageFormat.format(resourceBundle.getString("tooltip.entity.qualityTextField"), name));
    qualitySpinner.setAlignmentX(LEFT_ALIGNMENT);

    qualityPanel.add(qualityLabel);
    qualityPanel.add(qualitySpinner);
    constraintPanel.add(qualityPanel);
  }

  @Override
  protected void setControllers(EntityController<G> entityController) {
    super.setControllers(entityController);
    qualitySpinner.addPropertyChangeListener(((ItemController) controller).getRarityChangeListener());
  }

  public int getQuality() {
    return qualityNumberModel.getNumber().intValue();
  }
}
