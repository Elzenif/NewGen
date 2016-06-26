package nbk.model.entity.utils;

import nbk.model.entity.enums.EBodyPart;

/**
 * Created by Germain on 26/06/2016.
 */
public interface BodyPartBuilder extends IsBodyPart {

  BodyPartBuilder setBodyParts(EBodyPart first, EBodyPart... others);
}
