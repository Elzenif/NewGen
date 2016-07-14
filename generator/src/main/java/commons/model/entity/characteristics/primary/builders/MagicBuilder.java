package commons.model.entity.characteristics.primary.builders;

import commons.model.entity.characteristics.primary.fields.HasMagic;

/**
 * Created by Germain on 26/06/2016.
 */
public interface MagicBuilder extends HasMagic {

  MagicBuilder isMagic();

  MagicBuilder isRelic();
}
