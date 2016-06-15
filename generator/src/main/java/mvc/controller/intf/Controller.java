package mvc.controller.intf;

import mvc.view.MainFrame;

/**
 * Created by Germain on 08/06/2016.
 */
@FunctionalInterface
public interface Controller {

  void setControllers(MainFrame view);
}
