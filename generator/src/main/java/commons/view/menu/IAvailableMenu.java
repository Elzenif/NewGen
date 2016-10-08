package commons.view.menu;

import commons.model.commons.HasName;

/**
 * Created by Germain on 08/10/2016.
 */
public interface IAvailableMenu extends HasName<String> {

  Menu getMenu();
}
