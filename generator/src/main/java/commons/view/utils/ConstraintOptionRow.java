package commons.view.utils;

import commons.controller.intf.ConstraintOptionRowController;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

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

    constraintsCheckBoxLabel = new JLabel("Options");
    constraintsCheckBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBoxPanel = new JPanel();
    constraintsCheckBoxPanel.setLayout(new BoxLayout(constraintsCheckBoxPanel, BoxLayout.Y_AXIS));
    constraintsCheckBoxPanel.add(constraintsCheckBoxLabel);
    constraintsCheckBoxPanel.add(constraintsCheckBox);

    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));

  }

  protected void finalizeRowConstruction(String toolTipTextButton) {
    add(constraintPanel);

    generateButton = new JButton("Generate");
    generateButton.setFont(Constants.DAUPHINN_FONT);
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
