package commons.view.commons.results;

import commons.view.commons.FlowLayoutPanelRow;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class FlowLayoutResultRow<T extends Result<S>, S> extends FlowLayoutPanelRow implements ResultRow<T, S> {

  protected FlowLayoutResultRow(int hGap, int vGap) {
    super(hGap, vGap);
  }
}
