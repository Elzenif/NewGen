package commons.view.commons.options;

import commons.utils.StringUtils;
import commons.view.commons.BorderLayoutPanelRow;
import commons.view.commons.results.ResultRow;
import commons.view.utils.Constants;

import javax.swing.JLabel;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class BorderLayoutOptionRow<T extends ResultRow> extends BorderLayoutPanelRow implements OptionRow<T> {

  protected final JLabel infoLabel;
  protected final String name;

  protected BorderLayoutOptionRow(int labelSize, String name) {
    super(Constants.JPANEL_HGAP, Constants.JPANEL_VGAP);
    this.name = name;

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name));
    infoLabel.setFont(Constants.BENGUIAB_FONT);
  }
}
