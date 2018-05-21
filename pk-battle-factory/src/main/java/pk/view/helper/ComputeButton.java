package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;

@Component
public class ComputeButton extends Button implements Button.ClickListener {

  private final HelperModel helperModel;
  private final OwnTypeInfoPanel ownTypeInfoPanel;
  private final OpponentTypeInfoPanel opponentTypeInfoPanel;
  private final ResultPanel resultPanel;
  private HelperWindow helperWindow;

  public ComputeButton(HelperModel helperModel, OwnTypeInfoPanel ownTypeInfoPanel,
                       OpponentTypeInfoPanel opponentTypeInfoPanel, ResultPanel resultPanel) {
    super(Constants.resourceBundle.getString("compute"));
    this.helperModel = helperModel;
    this.ownTypeInfoPanel = ownTypeInfoPanel;
    this.opponentTypeInfoPanel = opponentTypeInfoPanel;
    this.resultPanel = resultPanel;

    addClickListener(this);
    setEnabled(true);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    helperModel.compute(helperWindow.getSelectedPokemons());
    ownTypeInfoPanel.refresh();
    opponentTypeInfoPanel.refresh();
    resultPanel.refresh();
  }

  @Autowired
  public void setHelperWindow(HelperWindow helperWindow) {
    this.helperWindow = helperWindow;
  }
}
