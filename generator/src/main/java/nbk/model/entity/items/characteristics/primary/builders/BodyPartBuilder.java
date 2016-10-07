package nbk.model.entity.items.characteristics.primary.builders;

import nbk.model.entity.items.characteristics.primary.fields.IsBodyPart;

/**
 * Created by Germain on 26/06/2016.
 */
public interface BodyPartBuilder extends IsBodyPart {

  BodyPartBuilder headPart();

  BodyPartBuilder torsoPart();

  BodyPartBuilder armsPart();

  BodyPartBuilder legsPart();

  BodyPartBuilder forearmsPart();

  BodyPartBuilder handsPart();

  BodyPartBuilder feetPart();

  BodyPartBuilder fullBody();

  BodyPartBuilder shieldPart();
}
