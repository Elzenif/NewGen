package nbk.model.entity.enums;

import nbk.model.entity.utils.HasSize;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public enum ESize implements HasSize{
  SMALL,
  NORMAL,
  LARGE;

  @Contract(pure = true)
  @Override
  public ESize getSize() {
    return this;
  }
}
