package commons.model.entity.characteristics.primary.enums;

import commons.model.commons.constraints.PrimarySecondaryConstraints;
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


  private static final PrimarySecondaryConstraints<EMagic> CONSTRAINTS = PrimarySecondaryConstraints.ConstraintsBuilder
      .<EMagic>start()
      .setSecondaryClass(EMagic.class)
      .setPrimaryClasses(EMagic.class)
      .build();

  public static PrimarySecondaryConstraints<EMagic> getConstraints() {
    return CONSTRAINTS;
  }

  @Contract(pure = true)
  @Override
  public EMagic getMagic() {
    return this;
  }

}
