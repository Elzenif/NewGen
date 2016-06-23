package commons.view.utils;

/**
 * Created by Germain on 08/06/2016.
 */
public abstract class OptionRow<T extends ResultRow> extends PanelRow {

  public abstract void setControllers(T resultRow);
}
