package pk.view;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.repository.TypeNameRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OptionWindow extends Window implements Button.ClickListener {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;
  private CheckBoxGroup<PokemonFactoryDTO> ownCheckBoxGroup;
  private CheckBoxGroup<PokemonFactoryDTO> opponentCheckBoxGroup;
  private VerticalLayout ownResultLayout;
  private VerticalLayout opponentResultLayout;
  private final GridLayout gridLayout;

  private final TypeNameRepository typeNameRepository;

  public OptionWindow(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel,
                      TypeNameRepository typeNameRepository) {
    super(Constants.resourceBundle.getString("menu.options"));
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
    this.typeNameRepository = typeNameRepository;

    ownCheckBoxGroup = buildCheckBox("panel.team.own");
    opponentCheckBoxGroup = buildCheckBox("panel.team.opponent");

    gridLayout = new GridLayout(2, 3);

    Button computeButton = new Button(Constants.resourceBundle.getString("compute"));
    computeButton.addClickListener(this);

    ownResultLayout = new VerticalLayout();
    opponentResultLayout = new VerticalLayout();

    gridLayout.addComponent(computeButton, 0, 0, 1, 0);
    gridLayout.addComponent(ownCheckBoxGroup, 0, 1);
    gridLayout.addComponent(opponentCheckBoxGroup, 1, 1);
    gridLayout.addComponent(ownResultLayout, 0, 2);
    gridLayout.addComponent(opponentResultLayout, 1, 2);


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

  private void refreshData(TeamPanel<? extends PkInfoRow> teamPanel, CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup) {
    List<PokemonFactoryDTO> pokemons = teamPanel.getPkInfoRows().stream()
        .map(PkInfoRow::getPokemonFactoryDTO)
        .collect(Collectors.toList());
    checkBoxGroup.setDataProvider(DataProvider.ofCollection(pokemons));
  }

  @Override
  public void buttonClick(Button.ClickEvent event) {
    ownResultLayout = buildResultLayout(ownCheckBoxGroup, ownResultLayout);
    opponentResultLayout = buildResultLayout(opponentCheckBoxGroup, opponentResultLayout);
  }


  private VerticalLayout buildResultLayout(CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup,
                                           VerticalLayout resultLayout) {
    Set<PokemonFactoryDTO> pokemons = checkBoxGroup.getSelectedItems();

    /*
    * Useful info?
    * List duels between each pair of pokemon
    * Colour code for easy winner, tough match up, balanced match up, to difficult to judge
    * In tooltip ->
    *   Damage calculation range of each attack
    *   Possibility of OHKO, 2 OHKO, etc...
    */

    VerticalLayout newResultLayout = new VerticalLayout();
    for (PokemonFactoryDTO pokemon : pokemons) {
      newResultLayout.addComponent(new Label(pokemon.getPkName()));
    }

    gridLayout.replaceComponent(resultLayout, newResultLayout);
    return newResultLayout;
  }
}
