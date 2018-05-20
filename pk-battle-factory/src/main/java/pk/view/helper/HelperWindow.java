package pk.view.helper;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import commons.utils.Pair;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import pk.model.data.OpponentPokemonRowModel;
import pk.model.data.OwnPokemonRowModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.utils.PkCheckBoxGroup;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class HelperWindow extends Window {

  private final ComputeButton computeButton;
  private final TypeInfoPanel typeInfoPanel;
  private final ResultPanel resultPanel;
  private final OwnPokemonRowModel ownPokemonRowModel;
  private final OpponentPokemonRowModel opponentPokemonRowModel;

  private PkCheckBoxGroup ownCheckBoxGroup;
  private PkCheckBoxGroup opponentCheckBoxGroup;

  public HelperWindow(ComputeButton computeButton, TypeInfoPanel typeInfoPanel, ResultPanel resultPanel,
                      OwnPokemonRowModel ownPokemonRowModel, OpponentPokemonRowModel opponentPokemonRowModel) {
    super(Constants.resourceBundle.getString("menu.helper"));
    this.computeButton = computeButton;
    this.typeInfoPanel = typeInfoPanel;
    this.resultPanel = resultPanel;
    this.ownPokemonRowModel = ownPokemonRowModel;
    this.opponentPokemonRowModel = opponentPokemonRowModel;
  }

  @PostConstruct
  public void init() {
    ownCheckBoxGroup = new PkCheckBoxGroup("panel.team.own");
    opponentCheckBoxGroup = new PkCheckBoxGroup("panel.team.opponent");
    ownCheckBoxGroup.addSelectionListener(e -> checkComputeButtonEnableState(ownCheckBoxGroup, opponentCheckBoxGroup));
    opponentCheckBoxGroup
        .addSelectionListener(e -> checkComputeButtonEnableState(ownCheckBoxGroup, opponentCheckBoxGroup));

    VerticalLayout mainLayout = new VerticalLayout(
        new HorizontalLayout(ownCheckBoxGroup, opponentCheckBoxGroup, computeButton),
        typeInfoPanel, resultPanel);
//    mainLayout.setHeight(100f, Unit.PERCENTAGE);
//    mainLayout.setWidth(100f, Unit.PERCENTAGE);

    setContent(mainLayout);

  }

  private void checkComputeButtonEnableState(@NotNull PkCheckBoxGroup ownCheckBoxGroup,
                                             @NotNull PkCheckBoxGroup opponentCheckBoxGroup) {
    computeButton.setEnabled(!ownCheckBoxGroup.isEmpty() && !opponentCheckBoxGroup.isEmpty());
  }

  public void refresh() {
    refreshData(ownCheckBoxGroup, ownPokemonRowModel.values());
    refreshData(opponentCheckBoxGroup, opponentPokemonRowModel.values());

    center();
    setHeight(80f, Unit.PERCENTAGE);
    setWidth(75f, Unit.PERCENTAGE);
  }

  private void refreshData(@NotNull PkCheckBoxGroup ownCheckBoxGroup, Collection<PokemonFactoryDTO> values) {
    ownCheckBoxGroup.setDataProvider(DataProvider.ofCollection(values));
    ownCheckBoxGroup.setValue(new HashSet<>(values));
  }

  public Pair<Set<PokemonFactoryDTO>, Set<PokemonFactoryDTO>> getSelectedPokemons() {
    return new Pair<>(ownCheckBoxGroup.getSelectedItems(), opponentCheckBoxGroup.getSelectedItems());
  }
}
