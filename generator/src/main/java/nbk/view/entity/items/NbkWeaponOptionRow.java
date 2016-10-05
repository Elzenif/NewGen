package nbk.view.entity.items;

import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.items.NbkWeaponController;
import nbk.model.entity.items.ENbkAvailableItem;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkItemOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final Map<ENbHands, JCheckBox> nbHandsButtons;
  private final JCheckBox oneHandCheckBox;
  private final JCheckBox twoHandsCheckBox;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);

    // hands constraints
    oneHandCheckBox = new JCheckBox(resourceBundle.getString("row.weapon.oneHandCheckBox"), false);
    oneHandCheckBox.setToolTipText(resourceBundle.getString("tooltip.weapon.oneHandCheckBox"));
    twoHandsCheckBox = new JCheckBox(resourceBundle.getString("row.weapon.twoHandsCheckBox"), false);
    twoHandsCheckBox.setToolTipText(resourceBundle.getString("tooltip.weapon.twoHandsCheckBox"));
    nbHandsButtons = new LinkedHashMap<>(2);
    nbHandsButtons.put(ENbHands.ONE, oneHandCheckBox);
    nbHandsButtons.put(ENbHands.TWO, twoHandsCheckBox);
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().forEach(nbHandsPanel::add);
    constraintPanel.add(nbHandsPanel);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(new NbkWeaponController(this, entityResultRow));
    nbHandsButtons.forEach((nbHands, jCheckBox) ->
        jCheckBox.addActionListener(((NbkWeaponController) controller).getNbHandsActionListener(nbHands)));
  }
}
