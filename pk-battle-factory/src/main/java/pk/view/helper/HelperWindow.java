package pk.view.helper;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.main.OpponentTeamPanel;
import pk.view.main.OwnTeamPanel;
import pk.view.main.PkInfoRow;
import pk.view.main.TeamPanel;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HelperWindow extends Window {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;
  private final ComputeButton computeButton;

  private GridLayout gridLayout;
  private CheckBoxGroup<PokemonFactoryDTO> ownCheckBoxGroup;
  private CheckBoxGroup<PokemonFactoryDTO> opponentCheckBoxGroup;
  private OwnResultPanel ownResultPanel;
  private OpponentResultPanel opponentResultPanel;

  public HelperWindow(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel,
                      ComputeButton computeButton) {
    super(Constants.resourceBundle.getString("menu.helper"));
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
    this.computeButton = computeButton;

  }

  @PostConstruct
  public void init() {
    ownCheckBoxGroup = buildCheckBox("panel.team.own");
    opponentCheckBoxGroup = buildCheckBox("panel.team.opponent");

    gridLayout = new GridLayout(2, 3);

    ownResultPanel = new OwnResultPanel();
    opponentResultPanel = new OpponentResultPanel();

    gridLayout.addComponent(computeButton, 0, 0, 1, 0);
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
    refreshData(ownTeamPanel, ownCheckBoxGroup);
    refreshData(opponentTeamPanel, opponentCheckBoxGroup);

    center();
    setHeight(75f, Unit.PERCENTAGE);
    setWidth(50f, Unit.PERCENTAGE);
  }

  private void refreshData(@NotNull TeamPanel<? extends PkInfoRow> teamPanel,
                           @NotNull CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup) {
    List<PokemonFactoryDTO> pokemons = teamPanel.getPkInfoRows().stream()
        .map(PkInfoRow::getPokemonFactoryDTO)
        .collect(Collectors.toList());
    checkBoxGroup.setDataProvider(DataProvider.ofCollection(pokemons));
  }

  public void refreshResults() {
    ownResultPanel = ownResultPanel.refresh(ownCheckBoxGroup, gridLayout);
    opponentResultPanel = opponentResultPanel.refresh(opponentCheckBoxGroup, gridLayout);
  }
}
