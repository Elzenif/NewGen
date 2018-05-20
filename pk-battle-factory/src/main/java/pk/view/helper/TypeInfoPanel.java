package pk.view.helper;

import com.google.common.collect.Table;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import org.springframework.stereotype.Component;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;
import pk.view.utils.PkImage;
import pk.view.utils.PkImageType;

import java.util.Map;

@Component
public class TypeInfoPanel extends GridLayout {

  private final HelperModel helperModel;

  public TypeInfoPanel(HelperModel helperModel) {
    this.helperModel = helperModel;
  }

  public void refresh() {
    removeAllComponents();
    // Types I'm weak to
    // -> intersection of weaknesses of my team

    // Types I'm neutral to
    // -> intersection of neutral resistances of my team

    // Types I'm resisting to
    // -> intersection of resistances of my team

    // OR

    // Grid of my pokemons in each row and all the types in each column
    // In each cell, the multiplier of damage I take + color code (x4, x2, x1, x0.5, x0.25, x0)
    // Total weakness/neutral/resistance row with global multiplier (up to x64 for 3 pokemon team)
    // Bonus -> hovering each cell gives you the potential attack from the opponent team + the damage calc for the given pokemon
    Table<PokemonFactoryDTO, Type, Float> typeMultiplierTable = helperModel.getTypeMultiplierTable();

    setColumns(typeMultiplierTable.columnKeySet().size() + 1);
    setRows(typeMultiplierTable.rowKeySet().size() + 2);

    int j = 1;
    for (Type type : typeMultiplierTable.columnKeySet()) {
      addComponent(PkImageType.of(type), j, 0);
      j++;
    }

    int i = 1;
    for (Map.Entry<PokemonFactoryDTO, Map<Type, Float>> rowMap : typeMultiplierTable.rowMap().entrySet()) {
      addComponent(PkImage.of(rowMap.getKey()), 0, i);
      j = 1;
      for (Float factor : rowMap.getValue().values()) {
        addComponent(new Label("x" + factor / 100f), j, i);
        j++;
      }
      i++;
    }


    setHeight(100f, Unit.PERCENTAGE);
    setWidth(100f, Unit.PERCENTAGE);
  }
}
