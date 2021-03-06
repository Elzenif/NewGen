package commons.view.commons.results;

import commons.view.commons.BorderLayoutPanelRow;

import javax.swing.JLabel;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class BorderLayoutResultRow<T extends Result<S>, S> extends BorderLayoutPanelRow
    implements ResultRow<T, S> {

  protected BorderLayoutResultRow(int hGap, int vGap, JLabel infoLabel) {
    super(hGap, vGap, infoLabel);
  }
}
