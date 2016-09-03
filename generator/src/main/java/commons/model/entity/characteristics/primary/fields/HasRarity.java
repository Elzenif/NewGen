package commons.model.entity.characteristics.primary.fields;

import commons.model.entity.characteristics.primary.enums.IRarity;

/**
 * Created by Germain on 07/06/2016.
 */
@FunctionalInterface
public interface HasRarity {

  IRarity getRarity();
}
