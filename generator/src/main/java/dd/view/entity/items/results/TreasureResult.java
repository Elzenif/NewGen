package dd.view.entity.items.results;

import commons.utils.CollectionUtils;
import commons.utils.ColorUtils;
import commons.view.entity.results.EntityResult;
import dd.model.entity.items.treasures.DDTreasure;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Germain on 27/10/2016.
 */
public class TreasureResult extends EntityResult {

  private final List<DDTreasure> treasures;

  public TreasureResult(List<DDTreasure> treasures) {
    this.treasures = treasures;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  @Override
  public String getRawResult() {
    return (treasures.isEmpty() || CollectionUtils.containsOnlyNull(treasures))
        ? "Rien de rien"
        : String.join(",  ", treasures.stream().map(DDTreasure::toString).collect(Collectors.toList()));
  }

  @Override
  public Color getColor() {
    return ColorUtils.BLACK;
  }
}
