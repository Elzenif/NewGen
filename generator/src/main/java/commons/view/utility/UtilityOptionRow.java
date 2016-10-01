package commons.view.utility;

import commons.controller.utility.UtilityController;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintOptionRow;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow
    extends ConstraintOptionRow<UtilityResultRow> {

  private final JLabel infoLabel;

  protected UtilityOptionRow(int labelSize, String name) {
    super(labelSize, name);

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    add(constraintsCheckBoxPanel);
  }

  protected void setControllers(UtilityController utilityController) {
    super.setControllers(utilityController);
    generateButton.addActionListener(((UtilityController) controller).getGenerateUtilityActionListener());
  }
}
