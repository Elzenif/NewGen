package nbk.controller.entity;

import commons.controller.entity.ItemController;
import commons.view.entity.EntityResultRow;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.view.entity.NbkArmorOptionRow;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 23/07/2016.
 */
public class NbkArmorController extends ItemController<NbkGame> {

  private EnumMap<EBodyPart, ActionListener> bodyPartActionListenerMap = new EnumMap<>(EBodyPart.class);

  public NbkArmorController(NbkArmorOptionRow entityOptionRow, EntityResultRow entityResultRow) {
    super(entityOptionRow, new GenerateNbkArmorActionListener(entityOptionRow, entityResultRow));

    Arrays.stream(EBodyPart.values()).forEach(bodyPart ->
            bodyPartActionListenerMap.put(bodyPart, new BodyPartActionListener(entityOptionRow, bodyPart)));
  }

  public ActionListener getBodyPartActionListener(EBodyPart bodyPart) {
    return bodyPartActionListenerMap.get(bodyPart);
  }

}
