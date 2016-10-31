package dd.model.entity.items.characteristics.fields;

import commons.model.entity.characteristics.primary.fields.HasMultipleRarities;
import commons.model.entity.characteristics.primary.fields.IRarityKey;
import dd.model.entity.items.factory.subfactory.DDTreasureSubFactory;

/**
 * Created by Germain on 30/10/2016.
 */
public interface DDMultipleRaritiesItemTypeFactory<K extends IRarityKey> extends HasMultipleRarities<K> {

  DDTreasureSubFactory getFactory();
}
