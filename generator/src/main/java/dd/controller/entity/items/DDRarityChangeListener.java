package dd.controller.entity.items;

import dd.view.entity.items.options.DDItemOptionRow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Germain on 27/10/2016.
 */
public class DDRarityChangeListener implements ChangeListener {

  private final DDItemOptionRow itemOptionRow;
  private final DDItemController itemController;

  public DDRarityChangeListener(DDItemOptionRow itemOptionRow, DDItemController itemController) {
    this.itemOptionRow = itemOptionRow;
    this.itemController = itemController;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    int rarityLevel = itemOptionRow.getQuality();
    itemController.updateRarityConstraint(rarityLevel);
  }
}
