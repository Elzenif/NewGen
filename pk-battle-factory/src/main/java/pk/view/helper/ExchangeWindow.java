package pk.view.helper;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.Window;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.data.OpponentPokemonModel;
import pk.model.data.OwnPokemonModel;
import pk.model.dto.PokemonFactoryDTO;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeWindow extends Window implements Button.ClickListener {

  private final OwnPokemonModel ownPokemonModel;
  private final OpponentPokemonModel opponentPokemonModel;
  private final RadioButtonGroup<PokemonFactoryDTO> ownRadioButtonGroup;
  private final RadioButtonGroup<PokemonFactoryDTO> opponentRadioButtonGroup;
  private final Button button;

  private final Map<Boolean, PokemonFactoryDTO> pokemonMap = new HashMap<>(2);

  @Autowired
  public ExchangeWindow(OwnPokemonModel ownPokemonModel, OpponentPokemonModel opponentPokemonModel) {
    this.ownPokemonModel = ownPokemonModel;
    this.opponentPokemonModel = opponentPokemonModel;

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
    ownRadioButtonGroup.setDataProvider(DataProvider.ofCollection(ownPokemonModel.values()));
    opponentRadioButtonGroup.setDataProvider(DataProvider.ofCollection(opponentPokemonModel.values()));

    center();
    setHeight(50f, Unit.PERCENTAGE);
    setWidth(50f, Unit.PERCENTAGE);
  }

  @Override
  public void buttonClick(Button.ClickEvent event) {
    PokemonFactoryDTO ownPokemon = pokemonMap.get(true);
    PokemonFactoryDTO opponentPokemon = pokemonMap.get(false);

    ownPokemonModel.replacePokemon(ownPokemon, opponentPokemon);
    opponentPokemonModel.replacePokemon(opponentPokemon, ownPokemon);

    getUI().removeWindow(this);
  }
}
