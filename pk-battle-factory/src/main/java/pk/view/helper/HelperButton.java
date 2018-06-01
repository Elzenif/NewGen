package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.stereotype.Component;

@Component
public class HelperButton extends Button implements Button.ClickListener {

  private final HelperWindow helperWindow;

  public HelperButton(HelperWindow helperWindow) {
    super(Constants.resourceBundle.getString("menu.helper"));
    this.helperWindow = helperWindow;

    addClickListener(this);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    getUI().removeWindow(helperWindow);
    helperWindow.refresh();
    getUI().addWindow(helperWindow);
  }
}