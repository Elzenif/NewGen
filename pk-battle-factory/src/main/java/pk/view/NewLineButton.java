package pk.view;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 13/07/2017.
 */
@Component
public class NewLineButton extends Button implements Button.ClickListener {

  private PkInfoGrid pkInfoGrid;

  @Autowired
  public NewLineButton() {
    super(Constants.resourceBundle.getString("newLine"));
    addClickListener(this);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    pkInfoGrid.newLine();
  }

  @Autowired
  public void setPkInfoGrid(PkInfoGrid pkInfoGrid) {
    this.pkInfoGrid = pkInfoGrid;
  }
}
