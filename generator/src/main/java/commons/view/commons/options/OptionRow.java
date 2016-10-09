package commons.view.commons.options;

import commons.utils.StringUtils;
import commons.view.commons.PanelRow;
import commons.view.commons.results.ResultRow;
import commons.view.utils.Constants;

import javax.swing.JLabel;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class OptionRow<T extends ResultRow> extends PanelRow {

  protected final JLabel infoLabel;
  protected final String name;

  protected OptionRow(int labelSize, String name) {
    super(Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
    this.name = name;

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name));
    infoLabel.setFont(Constants.BENGUIAB_FONT);
  }

  public abstract void setControllers(T resultRow);
}
