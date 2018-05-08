package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeButton extends Button implements Button.ClickListener {

  private final ExchangeWindow exchangeWindow;

  @Autowired
  public ExchangeButton(ExchangeWindow exchangeWindow) {
    super(Constants.resourceBundle.getString("exchange"));
    this.exchangeWindow = exchangeWindow;

    addClickListener(this);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    getUI().removeWindow(exchangeWindow);
    exchangeWindow.refresh();
    getUI().addWindow(exchangeWindow);
  }
}
