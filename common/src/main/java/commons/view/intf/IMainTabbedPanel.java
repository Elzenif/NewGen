package commons.view.intf;

import commons.controller.intf.Controller;

import java.util.List;

/**
 * Created by Germain on 02/04/2017.
 */
public interface IMainTabbedPanel<T extends IMainFrame> {

  List<Controller<T>> getControllers();
}
