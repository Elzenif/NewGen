package generator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * Created by Germain on 25/05/2017.
 */
@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

  private final TresorGenerator tresorGenerator;

  public VaadinUI(TresorGenerator tresorGenerator) {
    this.tresorGenerator = tresorGenerator;
  }

  @Override
  protected void init(VaadinRequest request) {
    setContent(tresorGenerator);
  }
}
