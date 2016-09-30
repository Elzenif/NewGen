package commons.view.utility;

import commons.model.commons.Game;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintOptionRow;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow<T extends Game> extends ConstraintOptionRow<UtilityResultRow> {

  private final JLabel infoLabel;

  protected UtilityOptionRow(int labelSize, String name) {
    super(labelSize, name);

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    add(constraintsCheckBoxPanel);
  }
}
