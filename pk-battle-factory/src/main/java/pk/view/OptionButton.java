package pk.view;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.stereotype.Component;

@Component
public class OptionButton extends Button implements Button.ClickListener {

  private final OptionWindow optionWindow;

  public OptionButton(OptionWindow optionWindow) {
    super(Constants.resourceBundle.getString("menu.options"));
    this.optionWindow = optionWindow;

    addClickListener(this);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    getUI().removeWindow(optionWindow);
    optionWindow.refresh();
    getUI().addWindow(optionWindow);
  }
}
