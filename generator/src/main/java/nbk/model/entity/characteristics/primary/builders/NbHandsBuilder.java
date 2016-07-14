package nbk.model.entity.characteristics.primary.builders;

import nbk.model.entity.characteristics.primary.fields.HasNbHands;

/**
 * Created by Germain on 28/06/2016.
 */
public interface NbHandsBuilder extends HasNbHands {

  NbHandsBuilder oneHand();

  NbHandsBuilder twoHands();
}
