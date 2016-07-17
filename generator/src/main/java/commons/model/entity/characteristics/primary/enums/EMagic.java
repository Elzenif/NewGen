package commons.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.characteristics.primary.fields.HasMagic;
import commons.model.entity.characteristics.secondary.Secondary;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 25/06/2016.
 */
public enum EMagic implements Primary, Secondary, HasMagic {

  NOPE,
  MAGIC,
  RELIC;


  @Contract(pure = true)
  @Override
  public EMagic getMagic() {
    return this;
  }
}
