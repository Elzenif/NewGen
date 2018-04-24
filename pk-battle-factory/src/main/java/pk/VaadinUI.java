package pk;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import pk.view.PkMainPanel;

@SpringUI
public class VaadinUI extends UI {

  private final PkMainPanel pkMainPanel;

  public VaadinUI(PkMainPanel pkMainPanel) {
    this.pkMainPanel = pkMainPanel;
  }

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    setContent(pkMainPanel);
  }
}
