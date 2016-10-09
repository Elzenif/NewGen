package commons.view.commons.options;

import commons.utils.StringUtils;
import commons.view.commons.FlowLayoutPanelRow;
import commons.view.commons.results.ResultRow;
import commons.view.utils.Constants;

import javax.swing.JLabel;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class FlowLayoutOptionRow<T extends ResultRow> extends FlowLayoutPanelRow implements OptionRow<T> {

  protected final JLabel infoLabel;
  protected final String name;

  protected FlowLayoutOptionRow(int labelSize, String name) {
    super(Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);
    this.name = name;

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name));
    infoLabel.setFont(Constants.BENGUIAB_FONT);
  }
}
