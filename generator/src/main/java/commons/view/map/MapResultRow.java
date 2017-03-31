package commons.view.map;

import commons.Constants;
import commons.view.commons.results.GraphResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.map.NbkDungeonController;
import nbk.view.map.results.DungeonResult;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.util.Collection;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 24/09/2016.
 */
public class MapResultRow extends GraphResultRow<DungeonResult> {

  public static final int MAX_ZOOM_SLIDER_VALUE = 5;
  private static final int DEFAULT_ZOOM_SLIDER_VALUE = 0;

  private final JButton saveMapButton;

  private final JLabel showGridLabel;
  private final JCheckBox showGridCheckBox;
  private final ConstraintPanel showGridPanel;

  private final JLabel zoomLabel;
  private final JSlider zoomSlider;
  private final ConstraintPanel zoomPanel;

  public MapResultRow() {
    super();

    saveMapButton = new JButton(resourceBundle.getString("row.dungeon.save"));
    saveMapButton.setToolTipText(resourceBundle.getString("tooltip.dungeon.save"));
    saveMapButton.setFont(Constants.DAUPHINN_FONT);
    optionRow.add(saveMapButton);

    // show grid panel
    showGridLabel = new JLabel(resourceBundle.getString("row.dungeon.showGrid"));
    showGridLabel.setAlignmentX(CENTER_ALIGNMENT);

    showGridCheckBox = new JCheckBox();
    showGridCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    showGridCheckBox.setSelected(false);

    showGridPanel = new ConstraintPanel();
    showGridPanel.setLayout(new BoxLayout(showGridPanel, BoxLayout.Y_AXIS));
    showGridPanel.add(showGridLabel);
    showGridPanel.add(showGridCheckBox);
    optionRow.add(showGridPanel);

    // zoom Panel
    zoomLabel = new JLabel(resourceBundle.getString("row.dungeon.zoom"));
    zoomLabel.setAlignmentX(CENTER_ALIGNMENT);

    zoomSlider = new JSlider(-MAX_ZOOM_SLIDER_VALUE, MAX_ZOOM_SLIDER_VALUE, DEFAULT_ZOOM_SLIDER_VALUE);
    zoomSlider.setAlignmentX(CENTER_ALIGNMENT);
    zoomSlider.setMinorTickSpacing(1);
    zoomSlider.setPaintTicks(true);

    zoomPanel = new ConstraintPanel();
    zoomPanel.setLayout(new BoxLayout(zoomPanel, BoxLayout.Y_AXIS));
    zoomPanel.add(zoomLabel);
    zoomPanel.add(zoomSlider);
    optionRow.add(zoomPanel);
  }

  public void setControllers(NbkDungeonController dungeonController) {
    saveMapButton.addActionListener(dungeonController.getSaveMapActionListener());
    showGridCheckBox.addItemListener(dungeonController.getShowGridItemListener());
    zoomSlider.addChangeListener(dungeonController.getZoomChangeListener());
  }

  public void setEnabledRowButtons(boolean b) {
    optionRow.setEnabled(b);
  }

  public boolean isShowGridCheckBoxSelected() {
    return showGridCheckBox.isSelected();
  }

  @Override
  public void setResultsToPrint(Collection<DungeonResult> results) {
    if (results.size() != 1) {
      throw new IllegalArgumentException("Should only print one result");
    }
    for (DungeonResult result : results) {
      resultToPrint.setMaxUnitIncrement(result.getTileSize());
      super.setResultsToPrint(result);
    }
  }

  public int getZoomValue() {
    return zoomSlider.getValue();
  }

  public void resetZoomValue() {
    zoomSlider.setValue(DEFAULT_ZOOM_SLIDER_VALUE);
  }
}
