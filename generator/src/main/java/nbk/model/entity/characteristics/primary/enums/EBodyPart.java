package nbk.model.entity.characteristics.primary.enums;

import nbk.model.entity.characteristics.primary.fields.IsBodyPart;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

/**
 * Created by Germain on 26/06/2016.
 */
public enum EBodyPart implements IsBodyPart {

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
}
