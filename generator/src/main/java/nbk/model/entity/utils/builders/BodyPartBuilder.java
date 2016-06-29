package nbk.model.entity.utils.builders;

import nbk.model.entity.enums.EBodyPart;
import nbk.model.entity.utils.fields.IsBodyPart;

/**
 * Created by Germain on 26/06/2016.
 */
public interface BodyPartBuilder extends IsBodyPart {

  BodyPartBuilder setBodyParts(EBodyPart first, EBodyPart... others);
}
