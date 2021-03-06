package dd.view.entity.items.options;

import commons.model.entity.items.IAvailableItem;
import commons.view.entity.items.ItemOptionRow;
import commons.view.utils.ViewUtils;
import dd.controller.entity.items.DDItemController;
import dd.model.commons.DDGame;
import dd.model.entity.items.treasures.DDTreasure;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 25/10/2016.
 */
public abstract class DDItemOptionRow extends ItemOptionRow<DDGame> {

  public static final int DEFAULT_LEVEL = 1;
  private final SpinnerNumberModel levelNumberModel;
  private final JSpinner levelSpinner;

  protected DDItemOptionRow(IAvailableItem<DDGame> availableItem) {
    super(availableItem, DDGame.getInstance().getAvailableItems());

    levelNumberModel = new SpinnerNumberModel(DEFAULT_LEVEL, 1, DDTreasure.LEVEL_MAX, 1);
    levelSpinner = new JSpinner(levelNumberModel);
    constraintPanel.add(ViewUtils.createSpinnerWithLabelOnTop(resourceBundle.getString("row.item.level"), levelSpinner,
        resourceBundle.getString("tooltip.entity.quality.dd")));
  }

  protected void setControllers(DDItemController itemController) {
    super.setControllers(itemController);
    levelSpinner.addChangeListener(((DDItemController) controller).getLevelChangeListener());
  }

  public int getLevel() {
    return levelNumberModel.getNumber().intValue();
  }
}
