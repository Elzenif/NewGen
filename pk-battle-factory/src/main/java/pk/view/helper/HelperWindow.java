package pk.view.helper;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import commons.utils.Pair;
import org.springframework.stereotype.Component;
import pk.model.data.OpponentPokemonRowModel;
import pk.model.data.OwnPokemonRowModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.utils.PkCheckBoxGroup;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class HelperWindow extends Window {

  private final ComputeButton computeButton;
  private final ExchangeButton exchangeButton;
  private final ResultPanel resultPanel;
  private final OwnPokemonRowModel ownPokemonRowModel;
  private final OpponentPokemonRowModel opponentPokemonRowModel;

  private PkCheckBoxGroup ownCheckBoxGroup;
  private PkCheckBoxGroup opponentCheckBoxGroup;

  public HelperWindow(ComputeButton computeButton, ExchangeButton exchangeButton, ResultPanel resultPanel,
                      OwnPokemonRowModel ownPokemonRowModel, OpponentPokemonRowModel opponentPokemonRowModel) {
    super(Constants.resourceBundle.getString("menu.helper"));
    this.computeButton = computeButton;
    this.exchangeButton = exchangeButton;
    this.ownPokemonRowModel = ownPokemonRowModel;
    this.opponentPokemonRowModel = opponentPokemonRowModel;
    this.resultPanel = resultPanel;
  }

  @PostConstruct
  public void init() {
    ownCheckBoxGroup = new PkCheckBoxGroup("panel.team.own");
    opponentCheckBoxGroup = new PkCheckBoxGroup("panel.team.opponent");
    ownCheckBoxGroup.addSelectionListener(e -> checkComputeButtonEnableState(ownCheckBoxGroup, opponentCheckBoxGroup));
    opponentCheckBoxGroup.addSelectionListener(e -> checkComputeButtonEnableState(ownCheckBoxGroup, opponentCheckBoxGroup));

    VerticalLayout buttonLayout = new VerticalLayout(computeButton, exchangeButton);

    HorizontalLayout mainLayout = new HorizontalLayout(ownCheckBoxGroup, opponentCheckBoxGroup, buttonLayout,
        resultPanel);
//    mainLayout.setHeight(100f, Unit.PERCENTAGE);
//    mainLayout.setWidth(100f, Unit.PERCENTAGE);

    setContent(mainLayout);

  }

  private void checkComputeButtonEnableState(PkCheckBoxGroup ownCheckBoxGroup, PkCheckBoxGroup opponentCheckBoxGroup) {
    computeButton.setEnabled(!ownCheckBoxGroup.isEmpty() && !opponentCheckBoxGroup.isEmpty());
  }

  public void refresh() {
    ownCheckBoxGroup.setDataProvider(DataProvider.ofCollection(ownPokemonRowModel.values()));
    opponentCheckBoxGroup.setDataProvider(DataProvider.ofCollection(opponentPokemonRowModel.values()));

    center();
    setHeight(80f, Unit.PERCENTAGE);
    setWidth(75f, Unit.PERCENTAGE);
  }

  /*
   * Useful info?
   * List duels between each pair of pokemon
   * Colour code for easy winner, tough match up, balanced match up, to difficult to judge
   * In tooltip ->
   *   Damage calculation range of each attack
   *   Possibility of OHKO, 2 OHKO, etc...
   */

  public Pair<Set<PokemonFactoryDTO>, Set<PokemonFactoryDTO>> getSelectedPokemons() {
    return new Pair<>(ownCheckBoxGroup.getSelectedItems(), opponentCheckBoxGroup.getSelectedItems());
  }
}
