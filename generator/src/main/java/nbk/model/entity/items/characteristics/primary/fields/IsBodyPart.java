package nbk.model.entity.items.characteristics.primary.fields;

import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;

import java.util.EnumSet;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface IsBodyPart {

  EnumSet<EBodyPart> getBodyParts();
}
