package commons.view.commons;

import commons.controller.intf.Controller;
import commons.model.commons.Gen;
import commons.view.ATabbedPanelEmbedded;
import commons.view.HiddenPanel;
import commons.view.PkMainFrame;

import javax.swing.JPanel;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/04/2017.
 */
public abstract class GenTabbedPanelEmbedded extends ATabbedPanelEmbedded<PkMainFrame> {

  protected final Map<String, JPanel> panelMap = new LinkedHashMap<>();

  protected final List<Controller<PkMainFrame>> controllers = new ArrayList<>();

  private final HiddenPanel hiddenPanel;

  public GenTabbedPanelEmbedded(Gen gen) {
    String path = "/images/" + gen.getRomanNumber() + ".png";
    URL resource = getClass().getResource(path);
    hiddenPanel = new HiddenPanel(path, resource);
    panelMap.put(resourceBundle.getString("panel.hidden"), hiddenPanel);
  }

  @Override
  public void setControllers(PkMainFrame mainFrame) {
    controllers.forEach(controller -> controller.setControllers(mainFrame));
  }

  protected void addPanels() {
    panelMap.forEach(this::addTab);
  }
}
