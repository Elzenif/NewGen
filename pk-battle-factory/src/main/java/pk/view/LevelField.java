package pk.view;

import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;
import commons.Constants;
import commons.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 17/07/2017.
 */
@Component
public class LevelField extends TextField implements HasValue.ValueChangeListener<String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LevelField.class);
  private static final int DEFAULT_LEVEL = 50;

  private final PokemonFactoryController pokemonFactoryController;
  private final List<PkInfoRow> pkInfoRows = new ArrayList<>(9);

  public LevelField(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
    setCaption(Constants.resourceBundle.getString("level"));
    setWidth(3, Unit.EM);
    setValue(String.valueOf(DEFAULT_LEVEL));
    addValueChangeListener(this);
  }

  @Override
  public void valueChange(ValueChangeEvent<String> event) {
    Integer value;
    try {
      if (StringUtils.isEmpty(event.getValue())) {
        value = DEFAULT_LEVEL;
        setValue(String.valueOf(value));
      } else {
        value = Integer.valueOf(event.getValue());
      }
      if (value < 0 || value > 100) {
        value = DEFAULT_LEVEL;
        setValue(String.valueOf(value));
      }
    } catch (NumberFormatException e) {
      LOGGER.error(String.format("Could not parse %s as an integer", event.getValue()));
      value = DEFAULT_LEVEL;
      setValue(String.valueOf(value));
    }
    pokemonFactoryController.setLevel(value);
    pkInfoRows.forEach(PkInfoRow::refresh);
  }

  @Autowired
  public void setPkInfoRows(List<TeamPanel<? extends PkInfoRow>> teamPanels) {
    for (TeamPanel<? extends PkInfoRow> teamPanel : teamPanels) {
      pkInfoRows.addAll(teamPanel.getPkInfoRows());
    }
  }
}
