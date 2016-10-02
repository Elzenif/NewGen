package commons.view.dungeon;

import commons.controller.dungeon.DungeonController;
import commons.model.dungeon.EDungeonType;
import commons.model.dungeon.IAvailableDungeon;
import commons.model.dungeon.constraints.EDungeonDraw;
import commons.utils.MathUtils;
import commons.utils.Pair;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintOptionRow;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.HasDrawKeysOptionRow;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonOptionRow extends ConstraintOptionRow<DungeonResultRow>
    implements HasDrawKeysOptionRow<EDungeonDraw> {

  private final JLabel infoLabel;

  private final ConstraintPanel basicOptionsPanel;

  private final EnumMap<EDungeonDraw, Pair<JSpinner, SpinnerNumberModel>> dungeonDrawMap;

  public DungeonOptionRow(IAvailableDungeon availableDungeon) {
    super(MathUtils.maxLength(Arrays.asList(EDungeonType.values())), availableDungeon.getName());

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    add(constraintsCheckBoxPanel);

    // basic options
    basicOptionsPanel = new ConstraintPanel();
    basicOptionsPanel.setLayout(new BoxLayout(basicOptionsPanel, BoxLayout.Y_AXIS));

    dungeonDrawMap = new EnumMap<>(EDungeonDraw.class);
    for (EDungeonDraw dungeonDraw : EDungeonDraw.values()) {
      JPanel jPanel = new ConstraintPanel();
      jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));
      // TODO change spinner
      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(5, 2, 20, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setToolTipText(dungeonDraw.getToolTipText());
      jPanel.add(jSpinner);
      JLabel jLabel = new JLabel(dungeonDraw.toString());
      jPanel.add(jLabel);

      dungeonDrawMap.put(dungeonDraw, new Pair<>(jSpinner, spinnerNumberModel));
      basicOptionsPanel.add(jPanel);
    }

    constraintPanel.add(basicOptionsPanel);

    finalizeRowConstruction("Generate a random " + name);
  }

  @Override
  public void setControllers(DungeonResultRow dungeonResultRow) {
    super.setControllers(new DungeonController(this, dungeonResultRow));
    DungeonController dungeonController = (DungeonController) this.controller;
    generateButton.addActionListener(dungeonController.getGenerateActionListener());
    dungeonResultRow.setController(dungeonController);
    dungeonDrawMap.forEach((dungeonDraw, pair) ->
        pair.getLeft().addChangeListener(dungeonController.getDrawChangeListener(dungeonDraw)));
  }

  @Override
  public int getDrawValue(EDungeonDraw drawKey) {
    return dungeonDrawMap.get(drawKey).getRight().getNumber().intValue();
  }
}
