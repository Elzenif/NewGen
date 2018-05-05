package pk.view.main;

import com.vaadin.data.HasValue;
import com.vaadin.ui.Slider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 17/07/2017.
 */
@Component
public class IVSlider extends Slider implements HasValue.ValueChangeListener<Double> {

  public static final double DEFAULT_IV = 0;

  private final PokemonFactoryController pokemonFactoryController;
  private final List<PkInfoRow> pkInfoRows = new ArrayList<>(9);

  public IVSlider(PokemonFactoryController pokemonFactoryController) {
    super("IV", 0, 31);
    this.pokemonFactoryController = pokemonFactoryController;
    setValue(DEFAULT_IV);
    addValueChangeListener(this);
  }

  @Override
  public void valueChange(ValueChangeEvent<Double> event) {
    pokemonFactoryController.setIv(event.getValue().intValue());
    pkInfoRows.forEach(PkInfoRow::refresh);
  }

  @Autowired
  public void setPkInfoRows(List<TeamPanel<? extends PkInfoRow>> teamPanels) {
    for (TeamPanel<? extends PkInfoRow> teamPanel : teamPanels) {
      pkInfoRows.addAll(teamPanel.getPkInfoRows());
    }
  }
}
