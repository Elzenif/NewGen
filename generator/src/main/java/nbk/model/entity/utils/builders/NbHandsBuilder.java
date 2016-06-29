package nbk.model.entity.utils.builders;

import nbk.model.entity.utils.fields.HasNbHands;

/**
 * Created by Germain on 28/06/2016.
 */
public interface NbHandsBuilder extends HasNbHands {

  NbHandsBuilder oneHand();

  NbHandsBuilder twoHands();
}
