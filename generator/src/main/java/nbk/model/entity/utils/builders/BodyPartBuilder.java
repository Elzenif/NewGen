package nbk.model.entity.utils.builders;

import nbk.model.entity.utils.fields.IsBodyPart;

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

  BodyPartBuilder shieldPart();
}
