package commons.view;

import commons.controller.intf.Controller;
import commons.view.intf.IMainFrame;
import commons.view.intf.ITabbedPanelEmbedded;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 02/04/2017.
 */
public abstract class ATabbedPanelEmbedded<T extends IMainFrame>
    extends JTabbedPane implements Controller<T>, ITabbedPanelEmbedded {

  protected final Map<String, JPanel> panelMap = new LinkedHashMap<>();

  protected ATabbedPanelEmbedded() {
    super(SwingConstants.TOP);
  }

  protected void addPanels() {
    panelMap.forEach(this::addTab);
  }
}
