package nbk.model.entity.utils.fields;

import nbk.model.entity.enums.EBodyPart;

import java.util.EnumSet;

/**
 * Created by Germain on 26/06/2016.
 */
@FunctionalInterface
public interface IsBodyPart {

  EnumSet<EBodyPart> getBodyParts();
}
