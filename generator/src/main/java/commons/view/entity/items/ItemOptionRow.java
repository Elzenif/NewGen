package commons.view.entity.items;

import commons.controller.entity.items.ItemController;
import commons.model.commons.Game;
import commons.model.entity.IAvailableEntity;
import commons.model.entity.items.IAvailableItem;
import commons.view.entity.EntityOptionRow;
import commons.view.utils.ViewUtils;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.MessageFormat;
import java.util.EnumSet;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemOptionRow<G extends Game> extends EntityOptionRow<G> {

  private final JSpinner qualitySpinner;
  private final SpinnerNumberModel qualityNumberModel;

  protected ItemOptionRow(IAvailableEntity<G> availableItem, EnumSet<? extends IAvailableItem<G>> availableItems) {
    super(availableItem, availableItems);

    qualityNumberModel = new SpinnerNumberModel(55, 1, 100, 1);
    qualitySpinner = new JSpinner(qualityNumberModel);
    constraintPanel.add(ViewUtils.createSpinnerWithLabelOnTop("D100", qualitySpinner,
        MessageFormat.format(resourceBundle.getString("tooltip.entity.quality.nbk"), name)));
  }

  protected void setControllers(ItemController<G> entityController) {
    super.setControllers(entityController);
    qualitySpinner.addChangeListener(((ItemController) controller).getRarityChangeListener());
  }

  public int getQuality() {
    return qualityNumberModel.getNumber().intValue();
  }
}
