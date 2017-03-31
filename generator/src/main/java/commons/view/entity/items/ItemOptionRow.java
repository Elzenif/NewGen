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

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 23/10/2016.
 */
public abstract class ItemOptionRow<G extends Game> extends EntityOptionRow<G> {

  public static final int DEFAULT_RARITY = 55;
  private final JSpinner raritySpinner;
  private final SpinnerNumberModel rarityNumberModel;

  protected ItemOptionRow(IAvailableEntity<G> availableItem, EnumSet<? extends IAvailableItem<G>> availableItems) {
    super(availableItem, availableItems);

    rarityNumberModel = new SpinnerNumberModel(DEFAULT_RARITY, 1, 100, 1);
    raritySpinner = new JSpinner(rarityNumberModel);
    constraintPanel.add(ViewUtils.createSpinnerWithLabelOnTop("D100", raritySpinner,
        MessageFormat.format(resourceBundle.getString("tooltip.entity.rarity.nbk"), name)));
  }

  protected void setControllers(ItemController<G> entityController) {
    super.setControllers(entityController);
    raritySpinner.addChangeListener(((ItemController) controller).getRarityChangeListener());
  }

  public int getRarity() {
    return rarityNumberModel.getNumber().intValue();
  }
}
