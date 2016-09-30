package commons.view.dungeon;

import commons.controller.dungeon.DungeonController;
import commons.view.dungeon.results.DungeonResult;
import commons.view.utils.GraphResultRow;

import javax.swing.JButton;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonResultRow extends GraphResultRow<DungeonResult> {

  private final JButton saveDungeonButton;

  public DungeonResultRow() {
    super();

    saveDungeonButton = new JButton("Save");
    saveDungeonButton.setToolTipText("Save the dungeon as an image");
    saveDungeonButton.setEnabled(false);
    add(saveDungeonButton);
  }

  public void setController(DungeonController dungeonController) {
    saveDungeonButton.addActionListener(dungeonController.getSaveDungeonActionListener());
  }

  public void setEnabledSaveButton(boolean b) {
    saveDungeonButton.setEnabled(b);
  }
}
