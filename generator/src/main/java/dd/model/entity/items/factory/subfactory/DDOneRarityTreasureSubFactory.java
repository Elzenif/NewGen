package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.DDTreasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class DDOneRarityTreasureSubFactory extends DDTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDOneRarityTreasureSubFactory.class);

  public List<DDTreasure> generate() {
    List<DDTreasure> treasures = new ArrayList<>(nb);
    for (int i = 0; i < nb; i++) {
      treasures.add(getTreasure());
    }
    return treasures;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  private DDTreasure getTreasure() {
    DDOneRarityItemType item;
    DDOneRarityItemType[] values = getValues();
    try {
      item = EntityUtils.selectRandomRarity(values, p -> true);
    } catch (NoAvailableEntityTypeException e) {
      item = values[0];
      LOGGER.error("Error while selecting random treasure", e);
    }
    return new DDTreasure(item.getName(), item.getValue());
  }

  protected abstract DDOneRarityItemType[] getValues();
}
