package commons.model.entity.utils.fields;

import commons.model.entity.enums.ERarity;

/**
 * Created by Germain on 07/06/2016.
 */
@FunctionalInterface
public interface HasRarity {

  ERarity getRarity();
}