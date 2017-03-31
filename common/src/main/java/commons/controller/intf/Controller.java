package commons.controller.intf;

import commons.view.intf.IMainFrame;

/**
 * Created by Germain on 08/06/2016.
 */
@FunctionalInterface
public interface Controller<T extends IMainFrame> {

  void setControllers(T mainFrame);
}
