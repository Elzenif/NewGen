package commons.view.map;

import commons.view.utils.GraphResultRow;
import nbk.controller.map.NbkDungeonController;
import nbk.view.map.results.DungeonResult;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapResultRow extends GraphResultRow<DungeonResult> {

  private final JButton saveMapButton;

  private final JCheckBox showGridCheckBox;
  private final JLabel showGridLabel;

  public MapResultRow() {
    super();

    saveMapButton = new JButton("Save");
    saveMapButton.setToolTipText("Save the map as an image");
    saveMapButton.setEnabled(false);
    add(saveMapButton);

    showGridCheckBox = new JCheckBox();
    showGridCheckBox.setSelected(false);
    showGridCheckBox.setEnabled(false);
    add(showGridCheckBox);

    showGridLabel = new JLabel("Show grid");
    showGridLabel.setEnabled(false);
    add(showGridLabel);
  }

  public void setController(NbkDungeonController dungeonController) {
    saveMapButton.addActionListener(dungeonController.getSaveMapActionListener());
    showGridCheckBox.addItemListener(dungeonController.getShowGridItemListener());
  }

  public void setEnabledRowButtons(boolean b) {
    saveMapButton.setEnabled(b);
    showGridCheckBox.setEnabled(b);
    showGridLabel.setEnabled(b);
  }

  public boolean isShowGridCheckBoxSelected() {
    return showGridCheckBox.isSelected();
  }
}
