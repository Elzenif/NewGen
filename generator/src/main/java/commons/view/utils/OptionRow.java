package commons.view.utils;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class OptionRow<T extends ResultRow> extends PanelRow {

  protected OptionRow() {
    super(Constants.JPANEL_HGAP, Constants.JPANEL_VGAP);
  }

  public abstract void setControllers(T resultRow);
}
