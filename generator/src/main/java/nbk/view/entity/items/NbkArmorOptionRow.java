package nbk.view.entity.items;

import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.items.NbkArmorController;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.ENbkAvailableItem;

import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkArmorOptionRow extends NbkEntityOptionRow {

  private final ConstraintPanel bodyPartPanel;
  private final Map<EBodyPart, JCheckBox> bodyPartCheckBoxes;

  NbkArmorOptionRow() {
    super(ENbkAvailableItem.ARMOR);

    // bodyPart constraints
    int count = EBodyPart.values().length;
    int sqrtCount = (int) (Math.sqrt(count)) + 1;
    bodyPartCheckBoxes = new LinkedHashMap<>(count);
    bodyPartPanel = new ConstraintPanel();
    bodyPartPanel.setLayout(new GridLayout(sqrtCount, sqrtCount));

    Arrays.stream(EBodyPart.values()).forEach(bodyPart -> {
      JCheckBox checkBox = new JCheckBox(bodyPart.toString(), false);
      checkBox.setToolTipText("Includes " + bodyPart.toString() + " armors");
      bodyPartCheckBoxes.put(bodyPart, checkBox);
      bodyPartPanel.add(checkBox);
    });
    constraintPanel.add(bodyPartPanel);

    finalizeRowConstruction();
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(new NbkArmorController(this, entityResultRow));
    bodyPartCheckBoxes.forEach((bodyPart, jCheckBox) ->
            jCheckBox.addActionListener(((NbkArmorController) itemController).getBodyPartActionListener(bodyPart)));
  }
}