package pk.view.main;

import com.vaadin.data.HasValue;
import com.vaadin.ui.Slider;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 17/07/2017.
 */
@Component
public class LevelSlider extends Slider implements HasValue.ValueChangeListener<Double> {

  public static final double DEFAULT_LEVEL = 50;

  private final PokemonFactoryController pokemonFactoryController;
  private final List<PkInfoRow> pkInfoRows = new ArrayList<>(9);

  public LevelSlider(PokemonFactoryController pokemonFactoryController) {
    super(Constants.resourceBundle.getString("level"), 1, 100);
    this.pokemonFactoryController = pokemonFactoryController;
    setValue(DEFAULT_LEVEL);
    addValueChangeListener(this);
  }

  @Override
  public void valueChange(ValueChangeEvent<Double> event) {
    pokemonFactoryController.setLevel(event.getValue().intValue());
    pkInfoRows.forEach(PkInfoRow::refreshStats);
  }

  @Autowired
  public void setPkInfoRows(List<TeamPanel<? extends PkInfoRow>> teamPanels) {
    for (TeamPanel<? extends PkInfoRow> teamPanel : teamPanels) {
      pkInfoRows.addAll(teamPanel.getPkInfoRows());
    }
  }
}
