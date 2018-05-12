package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;

@Component
public class ComputeButton extends Button implements Button.ClickListener {

  private final HelperModel helperModel;
  private final ResultPanel resultPanel;
  private HelperWindow helperWindow;

  public ComputeButton(HelperModel helperModel, ResultPanel resultPanel) {
    super(Constants.resourceBundle.getString("compute"));
    this.helperModel = helperModel;
    this.resultPanel = resultPanel;

    addClickListener(this);
    setEnabled(false);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    helperModel.compute(helperWindow.getSelectedPokemons());
    resultPanel.refresh();
  }

  @Autowired
  public void setHelperWindow(HelperWindow helperWindow) {
    this.helperWindow = helperWindow;
  }
}
