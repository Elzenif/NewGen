package nbk.model.entity.items.characteristics.primary.enums;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import nbk.model.entity.items.characteristics.primary.fields.IsBodyPart;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.function.Predicate;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EBodyPart implements Primary, IsBodyPart, GenericPredicateConstraint<EBodyPart> {

  HEAD(resourceBundle.getString("armor.bodyPart.head")),
  TORSO(resourceBundle.getString("armor.bodyPart.torso")),
  ARMS(resourceBundle.getString("armor.bodyPart.arms")),
  LEGS(resourceBundle.getString("armor.bodyPart.legs")),
  FOREARMS(resourceBundle.getString("armor.bodyPart.forearms")),
  HANDS(resourceBundle.getString("armor.bodyPart.hands")),
  FEET(resourceBundle.getString("armor.bodyPart.feet")),
  SHIELD(resourceBundle.getString("armor.bodyPart.shield"));


  private final String name;

  EBodyPart(String name) {
    this.name = name;
  }

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


  @Contract(pure = true)
  @Override
  public String toString() {
    return name;
  }
}
