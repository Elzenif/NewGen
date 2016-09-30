package commons.view.dungeon;

import commons.controller.dungeon.DungeonController;
import commons.model.dungeon.EDungeonType;
import commons.model.dungeon.IAvailableDungeon;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintOptionRow;
import commons.view.utils.ConstraintPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonOptionRow extends ConstraintOptionRow<DungeonResultRow> {


  private final JLabel infoLabel;

  private final ConstraintPanel basicOptionsPanel;

  private final ConstraintPanel nbRoomsDesiredPanel;
  private final JSpinner nbRoomsDesiredSpinner;
  private final SpinnerNumberModel nbRoomsDesiredModel;
  private final JLabel nbRoomsDesiredLabel;

  public DungeonOptionRow(IAvailableDungeon availableDungeon) {
    super(MathUtils.maxLength(Arrays.asList(EDungeonType.values())), availableDungeon.getName());

    infoLabel = new JLabel(StringUtils.leftAlign(labelSize, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    add(constraintsCheckBoxPanel);

    // basic options
    basicOptionsPanel = new ConstraintPanel();
    basicOptionsPanel.setLayout(new BoxLayout(basicOptionsPanel, BoxLayout.Y_AXIS));

    // nbRoomsDesired
    nbRoomsDesiredPanel = new ConstraintPanel();
    nbRoomsDesiredPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));
    nbRoomsDesiredModel = new SpinnerNumberModel(5, 2, 20, 1);
    nbRoomsDesiredSpinner = new JSpinner(nbRoomsDesiredModel);
    nbRoomsDesiredSpinner.setToolTipText("The number of rooms the dungeon will contain");
    nbRoomsDesiredPanel.add(nbRoomsDesiredSpinner);
    nbRoomsDesiredLabel = new JLabel("Rooms");
    nbRoomsDesiredPanel.add(nbRoomsDesiredLabel);

    basicOptionsPanel.add(nbRoomsDesiredPanel);

    constraintPanel.add(basicOptionsPanel);

    finalizeRowConstruction("Generate a random " + name);
  }

  @Override
  public void setControllers(DungeonResultRow dungeonResultRow) {
    super.setControllers(new DungeonController(this, dungeonResultRow));
    DungeonController dungeonController = (DungeonController) this.controller;
    generateButton.addActionListener(dungeonController.getGenerateDungeonActionListener());
    dungeonResultRow.setController(dungeonController);
  }

  public int getNbRoomsDesired() {
    return nbRoomsDesiredModel.getNumber().intValue();
  }
}
