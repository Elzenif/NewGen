package commons.view.map;

import commons.view.commons.results.GraphResultRow;
import nbk.controller.map.NbkDungeonController;
import nbk.view.map.results.DungeonResult;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapResultRow extends GraphResultRow<DungeonResult> {

  private final JButton saveMapButton;

  private final JCheckBox showGridCheckBox;
  private final JLabel showGridLabel;

  public MapResultRow() {
    super();

    saveMapButton = new JButton(resourceBundle.getString("row.dungeon.save"));
    saveMapButton.setToolTipText(resourceBundle.getString("tooltip.dungeon.save"));
    saveMapButton.setEnabled(false);
    optionRow.add(saveMapButton);

    showGridCheckBox = new JCheckBox();
    showGridCheckBox.setSelected(false);
    showGridCheckBox.setEnabled(false);
    optionRow.add(showGridCheckBox);

    showGridLabel = new JLabel(resourceBundle.getString("row.dungeon.showGrid"));
    showGridLabel.setEnabled(false);
    optionRow.add(showGridLabel);
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
