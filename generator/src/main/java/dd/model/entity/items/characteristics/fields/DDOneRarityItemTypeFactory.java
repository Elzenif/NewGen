package dd.model.entity.items.characteristics.fields;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import dd.model.entity.items.factory.subfactory.DDTreasureSubFactory;

/**
 * Created by Germain on 30/10/2016.
 */
public interface DDOneRarityItemTypeFactory extends HasRarity {

  @Override
  CustomRarity getRarity();

  DDTreasureSubFactory getFactory();
}
