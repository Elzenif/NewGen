package dd.model.entity.items.factory.subfactory;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import dd.model.entity.items.characteristics.fields.DDItemType;
import dd.model.entity.items.treasure.DDTreasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
public abstract class DDTreasureSubFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(DDTreasureSubFactory.class);
  private int nb = 1;

  public void setNumberToGenerate(int nb) {
    this.nb = nb;
  }

  public List<DDTreasure> generate() {
    List<DDTreasure> treasures = new ArrayList<>(nb);
    for (int i = 0; i < nb; i++) {
      treasures.add(getTreasure());
    }
    return treasures;
  }

  @SuppressWarnings("HardCodedStringLiteral")
  protected DDTreasure getTreasure() {
    DDItemType item;
    DDItemType[] values = getValues();
    try {
      item = EntityUtils.selectRandomRarity(values, p -> true);
    } catch (NoAvailableEntityTypeException e) {
      item = values[0];
      LOGGER.error("Error while selecting random treasure");
    }
    return new DDTreasure(item.getName(), item.getValue());
  }

  protected abstract DDItemType[] getValues();
}
