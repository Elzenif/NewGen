package pk.view.helper;

import com.vaadin.ui.Button;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;

@Component
public class ComputeButton extends Button implements Button.ClickListener {

  private final HelperModel helperModel;
  private final OwnTypeWeaknessPanel ownTypeWeaknessPanel;
  private final OpponentTypeWeaknessPanel opponentTypeWeaknessPanel;
  private final ResultPanel resultPanel;
  private HelperWindow helperWindow;

  public ComputeButton(HelperModel helperModel, OwnTypeWeaknessPanel ownTypeWeaknessPanel,
                       OpponentTypeWeaknessPanel opponentTypeWeaknessPanel, ResultPanel resultPanel) {
    super(Constants.resourceBundle.getString("compute"));
    this.helperModel = helperModel;
    this.ownTypeWeaknessPanel = ownTypeWeaknessPanel;
    this.opponentTypeWeaknessPanel = opponentTypeWeaknessPanel;
    this.resultPanel = resultPanel;

    addClickListener(this);
    setEnabled(true);
  }

  @Override
  public void buttonClick(ClickEvent event) {
    helperModel.compute(helperWindow.getSelectedPokemons());
    ownTypeWeaknessPanel.refresh();
    opponentTypeWeaknessPanel.refresh();
    resultPanel.refresh();
  }

  @Autowired
  public void setHelperWindow(HelperWindow helperWindow) {
    this.helperWindow = helperWindow;
  }
}
