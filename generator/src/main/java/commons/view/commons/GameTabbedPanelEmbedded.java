package commons.view.commons;

import commons.controller.intf.Controller;
import commons.model.commons.Game;
import commons.view.MainFrame;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Germain on 24/07/2016.
 */
public abstract class GameTabbedPanelEmbedded<T extends Game> extends JTabbedPane implements Controller {

  protected final Map<String, JPanel> panelMap = new LinkedHashMap<>();

  protected final List<Controller> controllers = new ArrayList<>();

  protected GameTabbedPanelEmbedded() {
    super(SwingConstants.TOP);
  }
  @Override
  public void setControllers(MainFrame mainFrame) {
    controllers.forEach(controller -> controller.setControllers(mainFrame));
  }

  protected void addPanels() {
    panelMap.forEach(this::addTab);
  }
}
