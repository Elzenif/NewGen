package nbk.view.entity.items.options;

import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.items.NbkArmorController;
import nbk.model.entity.items.ENbkAvailableItem;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;

import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkArmorOptionRow extends NbkItemOptionRow {

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
      String toolTipText = MessageFormat.format(resourceBundle.getString("tooltip.armor.bodyPartCheckBox"),
          bodyPart.toString());
      checkBox.setToolTipText(toolTipText);
      bodyPartCheckBoxes.put(bodyPart, checkBox);
      bodyPartPanel.add(checkBox);
    });
    constraintPanel.add(bodyPartPanel);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(new NbkArmorController(this, entityResultRow));
    bodyPartCheckBoxes.forEach((bodyPart, jCheckBox) ->
        jCheckBox.addActionListener(((NbkArmorController) controller).getBodyPartActionListener(bodyPart)));
  }
}
