package pk.view.main;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import pk.view.helper.ExchangeButton;
import pk.view.helper.HelperButton;

@org.springframework.stereotype.Component
public class ButtonLayout extends HorizontalLayout {

  public ButtonLayout(NewLineButton newLineButton, LevelSlider levelSlider, IVSlider ivSlider,
                      HelperButton helperButton, ExchangeButton exchangeButton) {
    add(newLineButton);
    add(ivSlider);
    add(levelSlider);
    add(helperButton);
    add(exchangeButton);
  }

  private void add(Component component) {
    addComponent(component);
    setComponentAlignment(component, Alignment.BOTTOM_CENTER);
  }
}
