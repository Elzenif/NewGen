package nbk.view.entity.items;

import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.items.NbkWeaponController;
import nbk.model.entity.items.ENbkAvailableItem;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 13/06/2016.
 */
public class NbkWeaponOptionRow extends NbkItemOptionRow {

  private final ConstraintPanel nbHandsPanel;
  private final Map<ENbHands, JCheckBox> nbHandsButtons;
  private final JCheckBox oneHandButton;
  private final JCheckBox twoHandsButton;

  NbkWeaponOptionRow() {
    super(ENbkAvailableItem.WEAPON);

    // hands constraints
    oneHandButton = new JCheckBox("1h", false);
    oneHandButton.setToolTipText("Includes one hand weapons");
    twoHandsButton = new JCheckBox("2h", false);
    twoHandsButton.setToolTipText("Includes two hands weapons");
    nbHandsButtons = new LinkedHashMap<>(2);
    nbHandsButtons.put(ENbHands.ONE, oneHandButton);
    nbHandsButtons.put(ENbHands.TWO, twoHandsButton);
    nbHandsPanel = new ConstraintPanel();
    nbHandsPanel.setLayout(new BoxLayout(nbHandsPanel, BoxLayout.Y_AXIS));
    nbHandsButtons.values().forEach(nbHandsPanel::add);
    constraintPanel.add(nbHandsPanel);

    finalizeRowConstruction("Generate a random " + name);
  }

  @Override
  public void setControllers(EntityResultRow entityResultRow) {
    super.setControllers(new NbkWeaponController(this, entityResultRow));
    nbHandsButtons.forEach((nbHands, jCheckBox) ->
        jCheckBox.addActionListener(((NbkWeaponController) controller).getNbHandsActionListener(nbHands)));
  }
}
