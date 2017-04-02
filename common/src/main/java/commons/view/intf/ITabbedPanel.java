package commons.view.intf;

/**
 * Created by Germain on 02/04/2017.
 */
public interface ITabbedPanel<T extends ITabbedPanelEmbedded> {

  boolean isDefault();

  T getTabbedPanelEmbedded();
}
