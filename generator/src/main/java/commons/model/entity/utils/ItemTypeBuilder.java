package commons.model.entity.utils;

import commons.model.entity.enums.ERarity;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public interface ItemTypeBuilder {

  ItemTypeBuilder setRarity(ERarity rarity);

  List getNames();

  ERarity getRarity();
}
