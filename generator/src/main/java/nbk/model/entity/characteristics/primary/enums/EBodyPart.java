package nbk.model.entity.characteristics.primary.enums;

import commons.model.entity.characteristics.primary.Primary;
import commons.model.entity.constraints.GenericConstraint;
import commons.utils.StringUtils;
import nbk.model.entity.characteristics.primary.fields.IsBodyPart;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EBodyPart implements Primary, IsBodyPart, GenericConstraint<EBodyPart> {

  HEAD,
  TORSO,
  ARMS,
  LEGS,
  FOREARMS,
  HANDS,
  FEET,
  SHIELD;


  @NotNull
  @Override
  public EnumSet<EBodyPart> getBodyParts() {
    return EnumSet.of(this);
  }

  @NotNull
  @Override
  public Predicate<EBodyPart> getPredicate() {
    return e -> e.getBodyParts().contains(this);
  }


  @Override
  public String toString() {
    return StringUtils.capitalizeFirstLetter(name());
  }
}
