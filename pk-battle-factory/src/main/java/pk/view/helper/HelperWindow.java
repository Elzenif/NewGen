package pk.view.helper;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import org.springframework.stereotype.Component;
import pk.model.data.OpponentPokemonModel;
import pk.model.data.OwnPokemonModel;
import pk.model.dto.PokemonFactoryDTO;

import javax.annotation.PostConstruct;

@Component
public class HelperWindow extends Window {

  private final ComputeButton computeButton;
  private final ExchangeButton exchangeButton;
  private final OwnPokemonModel ownPokemonModel;
  private final OpponentPokemonModel opponentPokemonModel;

  private GridLayout gridLayout;
  private CheckBoxGroup<PokemonFactoryDTO> ownCheckBoxGroup;
  private CheckBoxGroup<PokemonFactoryDTO> opponentCheckBoxGroup;
  private OwnResultPanel ownResultPanel;
  private OpponentResultPanel opponentResultPanel;

  public HelperWindow(ComputeButton computeButton, ExchangeButton exchangeButton,
                      OwnPokemonModel ownPokemonModel, OpponentPokemonModel opponentPokemonModel) {
    super(Constants.resourceBundle.getString("menu.helper"));
    this.computeButton = computeButton;
    this.exchangeButton = exchangeButton;
    this.ownPokemonModel = ownPokemonModel;
    this.opponentPokemonModel = opponentPokemonModel;
  }

  @PostConstruct
  public void init() {
    ownCheckBoxGroup = buildCheckBox("panel.team.own");
    opponentCheckBoxGroup = buildCheckBox("panel.team.opponent");

    gridLayout = new GridLayout(2, 3);

    ownResultPanel = new OwnResultPanel();
    opponentResultPanel = new OpponentResultPanel();

    HorizontalLayout buttonLayout = new HorizontalLayout(computeButton, exchangeButton);
    gridLayout.addComponent(buttonLayout, 0, 0, 1, 0);
    gridLayout.addComponent(ownCheckBoxGroup, 0, 1);
    gridLayout.addComponent(opponentCheckBoxGroup, 1, 1);
    gridLayout.addComponent(ownResultPanel, 0, 2);
    gridLayout.addComponent(opponentResultPanel, 1, 2);

    gridLayout.setHeight(100f, Unit.PERCENTAGE);
    gridLayout.setWidth(100f, Unit.PERCENTAGE);

    setContent(gridLayout);

  }

  private CheckBoxGroup<PokemonFactoryDTO> buildCheckBox(String captionKey) {
    CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup = new CheckBoxGroup<>(
        Constants.resourceBundle.getString(captionKey));
    checkBoxGroup.setItemCaptionGenerator(PokemonFactoryDTO::getPkName);
    checkBoxGroup.setItemEnabledProvider(p -> p.getPkName() != null);
    return checkBoxGroup;
  }

  public void refresh() {
    ownCheckBoxGroup.setDataProvider(DataProvider.ofCollection(ownPokemonModel.values()));
    opponentCheckBoxGroup.setDataProvider(DataProvider.ofCollection(opponentPokemonModel.values()));

    center();
    setHeight(75f, Unit.PERCENTAGE);
    setWidth(50f, Unit.PERCENTAGE);
  }

  public void refreshResults() {
    ownResultPanel = ownResultPanel.refresh(ownCheckBoxGroup, gridLayout);
    opponentResultPanel = opponentResultPanel.refresh(opponentCheckBoxGroup, gridLayout);
  }
}
