package commons.model.entity.enums;

import commons.model.commons.HasMagic;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 25/06/2016.
 */
public enum EMagic implements HasMagic {

  NOPE,
  MAGIC,
  RELIC;


  @Contract(pure = true)
  @Override
  public EMagic getMagic() {
    return this;
  }
}
