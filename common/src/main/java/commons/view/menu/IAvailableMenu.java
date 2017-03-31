package commons.view.menu;

import commons.model.utils.HasName;
import commons.view.intf.IMainFrame;

/**
 * Created by Germain on 08/10/2016.
 */
public interface IAvailableMenu<T extends IMainFrame> extends HasName<String> {

  AMenu<T> getMenu();
}
