package commons.view.utility;

import commons.model.commons.Game;
import commons.view.utils.Constants;
import commons.view.utils.OptionRow;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class UtilityOptionRow<T extends Game> extends OptionRow<UtilityResultRow> {

  private final JLabel infoLabel;


  protected UtilityOptionRow(String infoString) {
    super();
    infoLabel = new JLabel(infoString + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

  }
}
