package nbk.view.map.options;

import commons.model.map.EMapType;
import commons.model.map.IAvailableMap;
import commons.utils.MathUtils;
import commons.view.commons.options.ConstraintOptionRow;
import commons.view.commons.options.HasDrawKeysOptionRow;
import commons.view.map.MapResultRow;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintPanel;
import nbk.controller.map.NbkDungeonController;
import nbk.model.map.dungeon.constraints.EDungeonDraw;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EnumMap;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 24/09/2016.
 */
public class NbkDungeonOptionRow extends ConstraintOptionRow<MapResultRow>
    implements HasDrawKeysOptionRow<EDungeonDraw> {

  private final ConstraintPanel basicOptionsPanel;

  private final EnumMap<EDungeonDraw, JComboBox<Object>> dungeonDrawMap;

  public NbkDungeonOptionRow(IAvailableMap availableDungeon) {
    super(MathUtils.maxLength(Arrays.asList(EMapType.values())), availableDungeon.getName());

    leftPanel.add(infoLabel);

    centerPanel.add(constraintsCheckBoxPanel);

    // basic options
    basicOptionsPanel = new ConstraintPanel();
    basicOptionsPanel.setLayout(new BoxLayout(basicOptionsPanel, BoxLayout.Y_AXIS));

    dungeonDrawMap = new EnumMap<>(EDungeonDraw.class);
    for (EDungeonDraw dungeonDraw : EDungeonDraw.values()) {
      JPanel jPanel = new ConstraintPanel();
      jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP / 2));
      JComboBox<Object> jComboBox = new JComboBox<>(dungeonDraw.getDrawValues());
      jComboBox.setSelectedItem(dungeonDraw.getDefaultValue());
      jComboBox.setToolTipText(dungeonDraw.getToolTipText());
      jPanel.add(jComboBox);
      dungeonDrawMap.put(dungeonDraw, jComboBox);
      JLabel jLabel = new JLabel(dungeonDraw.toString());
      jPanel.add(jLabel);
      basicOptionsPanel.add(jPanel);
    }

    constraintPanel.add(basicOptionsPanel);

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.dungeon.generate"), name));
  }

  @Override
  public void setControllers(MapResultRow dungeonResultRow) {
    super.setControllers(new NbkDungeonController(this, dungeonResultRow));
    NbkDungeonController dungeonController = (NbkDungeonController) this.controller;
    generateButton.addActionListener(dungeonController.getGenerateActionListener());
    dungeonResultRow.setControllers(dungeonController);
    dungeonDrawMap.forEach((dungeonDraw, comboBox) ->
        comboBox.addActionListener(dungeonController.getDrawChangeListener(dungeonDraw)));
  }

  @Override
  public Object getDrawValue(EDungeonDraw drawKey) {
    return dungeonDrawMap.get(drawKey).getSelectedItem();
  }
}
