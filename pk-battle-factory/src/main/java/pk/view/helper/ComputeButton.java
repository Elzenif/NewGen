package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComputeButton extends Button implements Button.ClickListener {

  private HelperWindow helperWindow;

  public ComputeButton() {
    super(Constants.resourceBundle.getString("compute"));

    addClickListener(this);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    helperWindow.refreshResults();
  }

  @Autowired
  public void setHelperWindow(HelperWindow helperWindow) {
    this.helperWindow = helperWindow;
  }
}
