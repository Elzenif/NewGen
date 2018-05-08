package pk.view.helper;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.Window;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.ViewUtils;
import pk.view.main.OpponentTeamPanel;
import pk.view.main.OwnTeamPanel;
import pk.view.main.PkInfoRow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ExchangeWindow extends Window implements Button.ClickListener {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;
  private final RadioButtonGroup<PokemonFactoryDTO> ownRadioButtonGroup;
  private final RadioButtonGroup<PokemonFactoryDTO> opponentRadioButtonGroup;
  private final Button button;

  private Map<Boolean, PokemonFactoryDTO> pokemonMap = new HashMap<>(2);

  @Autowired
  public ExchangeWindow(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel) {
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;

    ownRadioButtonGroup = buildRadioButtonGroup("panel.team.own", true);
    opponentRadioButtonGroup = buildRadioButtonGroup("panel.team.opponent", false);

    button = new Button(Constants.resourceBundle.getString("exchange"));
    button.setEnabled(false);
    button.addClickListener(this);

    HorizontalLayout layout = new HorizontalLayout(ownRadioButtonGroup, opponentRadioButtonGroup, button);
    setContent(layout);
  }

  private RadioButtonGroup<PokemonFactoryDTO> buildRadioButtonGroup(String captionKey, boolean isOwn) {
    RadioButtonGroup<PokemonFactoryDTO> radioButtonGroup = new RadioButtonGroup<>(
        Constants.resourceBundle.getString(captionKey));
    radioButtonGroup.setItemCaptionGenerator(PokemonFactoryDTO::getPkName);
    radioButtonGroup.setItemEnabledProvider(p -> p.getPkName() != null);
    radioButtonGroup.addSelectionListener(event -> updatePokemonMap(isOwn, event.getValue()));
    return radioButtonGroup;
  }

  private void updatePokemonMap(boolean isOwn, PokemonFactoryDTO value) {
    pokemonMap.put(isOwn, value);
    if (pokemonMap.size() == 2) {
      button.setEnabled(true);
    }
  }

  public void refresh() {
    ViewUtils.refreshData(ownTeamPanel, ownRadioButtonGroup);
    ViewUtils.refreshData(opponentTeamPanel, opponentRadioButtonGroup);

    center();
    setHeight(50f, Unit.PERCENTAGE);
    setWidth(50f, Unit.PERCENTAGE);
  }

  @Override
  public void buttonClick(Button.ClickEvent event) {
    PokemonFactoryDTO ownPokemon = pokemonMap.get(true);
    PokemonFactoryDTO opponentPokemon = pokemonMap.get(false);

    Map<PokemonFactoryDTO, PkInfoRow> ownPokemons = ownTeamPanel.getPkInfoRows().stream()
        .filter(PkInfoRow::hasOnePokemon)
        .collect(Collectors.toMap(PkInfoRow::getPokemonFactoryDTO, p -> p));
    Map<PokemonFactoryDTO, PkInfoRow> opponentPokemons = opponentTeamPanel.getPkInfoRows().stream()
        .filter(PkInfoRow::hasOnePokemon)
        .collect(Collectors.toMap(PkInfoRow::getPokemonFactoryDTO, p -> p));

    ownPokemons.get(ownPokemon).setPokemonAndShowText(opponentPokemon);
    opponentPokemons.get(opponentPokemon).setPokemonAndShowText(ownPokemon);

    getUI().removeWindow(this);
  }
//
//  @Autowired
//  public void setPkInfoRows(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel) {
//    ownInfoRows.addAll(ownTeamPanel.getPkInfoRows());
//    opponentInfoRows.addAll(opponentTeamPanel.getPkInfoRows());
//  }
}
