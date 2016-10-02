package commons.view.map;

import commons.view.utils.GraphResultRow;
import nbk.controller.map.NbkDungeonController;
import nbk.view.map.results.DungeonResult;

import javax.swing.JButton;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapResultRow extends GraphResultRow<DungeonResult> {

  private final JButton saveMapButton;

  public MapResultRow() {
    super();

    saveMapButton = new JButton("Save");
    saveMapButton.setToolTipText("Save the map as an image");
    saveMapButton.setEnabled(false);
    add(saveMapButton);
  }

  public void setController(NbkDungeonController dungeonController) {
    saveMapButton.addActionListener(dungeonController.getSaveMapActionListener());
  }

  public void setEnabledSaveButton(boolean b) {
    saveMapButton.setEnabled(b);
  }
}
