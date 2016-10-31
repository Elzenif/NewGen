package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.characteristics.fields.DDMultipleRaritiesItemType;
import dd.model.entity.items.treasures.DDTreasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class DDMultipleRaritiesTreasureSubFactory extends DDTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDMultipleRaritiesTreasureSubFactory.class);

  public List<DDTreasure> generate(EDDItemPowerRarityKey powerRarityKey) {
    List<DDTreasure> treasures = new ArrayList<>(nb);
    for (int i = 0; i < nb; i++) {
      treasures.add(getTreasure(powerRarityKey));
    }
    return treasures;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  private DDTreasure getTreasure(EDDItemPowerRarityKey powerRarityKey) {
    DDMultipleRaritiesItemType item;
    DDMultipleRaritiesItemType[] values = getValues(powerRarityKey);
    try {
      item = EntityUtils.selectRandomWithCustomRarity(values, powerRarityKey);
    } catch (NoAvailableEntityTypeException e) {
      item = values[0];
      LOGGER.error("Error while selecting random treasure");
    }
    return new DDTreasure(item.getName(), item.getValue());

  }

  protected abstract DDMultipleRaritiesItemType[] getValues(EDDItemPowerRarityKey powerRarityKey);
}
