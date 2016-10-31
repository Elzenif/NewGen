package dd.model.entity.items.characteristics.fields;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;

/**
 * Created by Germain on 31/10/2016.
 */
public interface DDOneRarityItemType extends DDItemType, HasRarity {

  @Override
  CustomRarity getRarity();
}
