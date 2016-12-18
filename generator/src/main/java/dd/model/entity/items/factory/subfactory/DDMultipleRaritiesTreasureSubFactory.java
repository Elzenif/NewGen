package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;
import dd.model.entity.items.treasures.DDTreasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 31/10/2016.
 */
public abstract class DDMultipleRaritiesTreasureSubFactory extends DDTreasureSubFactory {

  public List<DDTreasure> generate(EDDItemPowerRarityKey powerRarityKey) {
    List<DDTreasure> treasures = new ArrayList<>(nb);
    for (int i = 0; i < nb; i++) {
      treasures.add(getTreasure(powerRarityKey));
    }
    return treasures;
  }

  protected abstract DDTreasure getTreasure(EDDItemPowerRarityKey powerRarityKey);
}
