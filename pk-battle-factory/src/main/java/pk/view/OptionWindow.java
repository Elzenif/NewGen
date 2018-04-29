package pk.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import commons.Constants;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OptionWindow extends Window {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;

  public OptionWindow(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel) {
    super(Constants.resourceBundle.getString("menu.options"));
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
  }

  public void refresh() {
    VerticalLayout mainLayout = new VerticalLayout();
    List<PokemonFactoryDTO> ownPokemons = ownTeamPanel.getPkInfoRows().stream()
        .map(PkInfoRow::getPokemonFactoryDTO)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    for (PokemonFactoryDTO ownPokemon : ownPokemons) {
      mainLayout.addComponent(new Label(ownPokemon.toString()));
    }

    setContent(mainLayout);
  }
}
