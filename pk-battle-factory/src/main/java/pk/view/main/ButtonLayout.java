package pk.view.main;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@org.springframework.stereotype.Component
public class ButtonLayout extends HorizontalLayout {

  public ButtonLayout(NewLineButton newLineButton, LevelSlider levelSlider, IVSlider ivSlider,
                      HelperButton helperButton) {
    add(newLineButton);
    add(ivSlider);
    add(levelSlider);
    add(helperButton);
  }

  private void add(Component component) {
    addComponent(component);
    setComponentAlignment(component, Alignment.BOTTOM_CENTER);
  }
}
