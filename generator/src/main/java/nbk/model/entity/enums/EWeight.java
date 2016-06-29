package nbk.model.entity.enums;

import nbk.model.entity.utils.fields.HasWeight;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EWeight implements HasWeight {

  LIGHT,
  NORMAL,
  HEAVY;


  @Contract(pure = true)
  @Override
  public EWeight getWeight() {
    return this;
  }
}
