package commons.view.commons.options;

import commons.controller.intf.ConstraintOptionRowController;
import commons.view.commons.results.ResultRow;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.HasConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import static commons.view.utils.Constants.DAUPHINN_FONT;
import static commons.view.utils.Constants.JPANEL_HGAP;
import static commons.view.utils.Constants.JPANEL_VGAP;
import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 29/09/2016.
 */
public abstract class ConstraintOptionRow<T extends ResultRow> extends OptionRow<T>
    implements HasConstraintPanel {

  protected final JPanel constraintsCheckBoxPanel;

  protected final ConstraintPanel constraintPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsCheckBoxLabel;

  protected JButton generateButton;

  protected ConstraintOptionRowController controller;

  protected ConstraintOptionRow(int labelSize, String name) {
    super(labelSize, name);

    constraintsCheckBoxLabel = new JLabel(resourceBundle.getString("row.options"));
    constraintsCheckBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBoxPanel = new JPanel();
    constraintsCheckBoxPanel.setLayout(new BoxLayout(constraintsCheckBoxPanel, BoxLayout.Y_AXIS));
    constraintsCheckBoxPanel.add(constraintsCheckBoxLabel);
    constraintsCheckBoxPanel.add(constraintsCheckBox);

    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, JPANEL_HGAP / 2, JPANEL_VGAP));

  }

  protected void finalizeRowConstruction(String toolTipTextButton) {
    add(constraintPanel);

    generateButton = new JButton(resourceBundle.getString("row.generate"));
    generateButton.setFont(DAUPHINN_FONT);
    generateButton.setToolTipText(toolTipTextButton);
    add(generateButton);

    updateConstraintsAbility(false);
  }


  protected void setControllers(ConstraintOptionRowController controller) {
    this.controller = controller;
    constraintsCheckBox.addItemListener(controller.getConstraintsItemListener());
  }

  @Override
  public boolean isConstraintsCheckBoxSelected() {
    return constraintsCheckBox.isSelected();
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    constraintPanel.setEnabled(checkBoxSelected);
  }

}
