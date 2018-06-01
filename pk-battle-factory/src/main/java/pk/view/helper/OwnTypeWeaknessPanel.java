package pk.view.helper;

import com.google.common.collect.Table;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;

@Component
public class OwnTypeWeaknessPanel extends TypeWeaknessPanel {

  public OwnTypeWeaknessPanel(HelperModel helperModel) {
    super(helperModel, "panel.team.own.weaknesses");
  }

  @Override
  protected Table<PokemonFactoryDTO, Type, Float> getTypeMultiplierTable() {
    return helperModel.getOwnTypeMultiplierTable();
  }
}