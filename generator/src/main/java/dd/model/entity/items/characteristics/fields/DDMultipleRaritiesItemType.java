package dd.model.entity.items.characteristics.fields;

import commons.model.entity.characteristics.primary.fields.HasMultipleRarities;
import dd.model.entity.items.characteristics.EDDItemPowerRarityKey;

/**
 * Created by Germain on 31/10/2016.
 */
public interface DDMultipleRaritiesItemType extends DDItemType, HasMultipleRarities<EDDItemPowerRarityKey> {

  @Override
  String getName();
}
