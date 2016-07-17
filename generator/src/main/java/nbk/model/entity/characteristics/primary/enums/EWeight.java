package nbk.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import nbk.model.entity.characteristics.primary.fields.HasWeight;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EWeight implements Primary, HasWeight {

  LIGHT,
  NORMAL,
  HEAVY;


  @Contract(pure = true)
  @Override
  public EWeight getWeight() {
    return this;
  }
}
