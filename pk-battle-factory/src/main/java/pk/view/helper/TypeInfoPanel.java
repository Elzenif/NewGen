package pk.view.helper;

import com.google.common.collect.Table;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import commons.Constants;
import org.jetbrains.annotations.NotNull;
import pk.model.data.HelperModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;
import pk.view.utils.PkImage;
import pk.view.utils.PkImageType;

import java.util.Map;

public abstract class TypeInfoPanel extends GridLayout {

  protected final HelperModel helperModel;

  protected TypeInfoPanel(HelperModel helperModel, String captionKey) {
    this.helperModel = helperModel;
    setCaption(Constants.resourceBundle.getString(captionKey));
  }

  public void refresh() {
    removeAllComponents();

    // Grid of my pokemons in each row and all the types in each column
    // In each cell, the multiplier of damage I take + color code (x4, x2, x1, x0.5, x0.25, x0)
    // Total weakness/neutral/resistance row with global multiplier (up to x64 for 3 pokemon team)
    // Bonus -> hovering each cell gives you the potential attack from the opponent team + the damage calc for the given pokemon
    Table<PokemonFactoryDTO, Type, Float> typeMultiplierTable = getTypeMultiplierTable();

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
        addComponent(getFactorLabel(factor), j, i);
        j++;
      }
      i++;
    }

    j = 1;
    for (Map.Entry<Type, Map<PokemonFactoryDTO, Float>> columnMap : typeMultiplierTable.columnMap().entrySet()) {
      int finalJ = j;
      int finalI = i;
      columnMap.getValue().values().stream()
          .reduce((a, b) -> a * b / 100)
          .ifPresent(factor -> addComponent(getFactorLabel(factor), finalJ, finalI));
      j++;
    }

    setHeight(100f, Unit.PERCENTAGE);
    setWidth(100f, Unit.PERCENTAGE);
  }

  protected abstract Table<PokemonFactoryDTO, Type, Float> getTypeMultiplierTable();

  @SuppressWarnings("SpellCheckingInspection")
  @NotNull
  private Label getFactorLabel(Float factor) {
    float value = factor / 100f;

    String colorCode;
    if (value == 0f) {
      colorCode = "737373";
    } else if (value == 1f) {
      colorCode = "D9D9D9";
    } else if (value > 1f) {
      colorCode = "E63900";
    } else {
      colorCode = "59B300";
    }
    return new Label("<div style=\"background-color:#" + colorCode + ";\">x" + value + "</div>", ContentMode.HTML);
  }
}
