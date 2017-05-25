package commons.view.commons;

import commons.controller.intf.Controller;
import commons.model.commons.Gen;
import commons.view.ATabbedPanelEmbedded;
import commons.view.HiddenPanel;
import commons.view.PkMainFrame;

import java.util.ArrayList;
import java.util.List;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/04/2017.
 */
public abstract class GenTabbedPanelEmbedded extends ATabbedPanelEmbedded<PkMainFrame> {

  protected final List<Controller<PkMainFrame>> controllers = new ArrayList<>();

  public GenTabbedPanelEmbedded(Gen gen) {
    HiddenPanel hiddenPanel = new HiddenPanel( gen.getRomanNumber());
    panelMap.put(resourceBundle.getString("panel.hidden"), hiddenPanel);
  }

  @Override
  public void setControllers(PkMainFrame mainFrame) {
    controllers.forEach(controller -> controller.setControllers(mainFrame));
  }

}
