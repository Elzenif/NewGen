package dd.model.entity.items.characteristics.fields;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.EntityType;

/**
 * Created by Germain on 29/10/2016.
 */
public interface DDItemType extends EntityType<String> {

  @Override
  CustomRarity getRarity();

  String getValue();
}
