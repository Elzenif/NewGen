package pk.view.helper;

import com.google.common.collect.Table;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;

@Component
public class OpponentTypeWeaknessPanel extends TypeWeaknessPanel {

  public OpponentTypeWeaknessPanel(HelperModel helperModel) {
    super(helperModel, "panel.team.opponent.weaknesses");
  }

  @Override
  protected Table<PokemonFactoryDTO, Type, Float> getTypeMultiplierTable() {
    return helperModel.getOpponentTypeMultiplierTable();
  }
}
