package commons.view.commons.options;

import commons.Constants;
import commons.utils.StringUtils;
import commons.view.commons.BorderLayoutPanelRow;
import commons.view.commons.results.ResultRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class BorderLayoutOptionRow<T extends ResultRow> extends BorderLayoutPanelRow implements OptionRow<T> {

  protected final String name;

  protected BorderLayoutOptionRow(int labelSize, String name) {
    super(Constants.JPANEL_HGAP, Constants.JPANEL_VGAP, new JLabel(StringUtils.leftAlign(labelSize, name)));
    this.name = name;
  }
}
