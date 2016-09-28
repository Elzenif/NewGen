package commons.view.dungeon;

import commons.controller.dungeon.DungeonController;
import commons.model.dungeon.EDungeonType;
import commons.model.dungeon.IAvailableDungeon;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.HasConstraintPanel;
import commons.view.utils.OptionRow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;

/**
 * Created by Germain on 24/09/2016.
 * TODO refactor with entityOptionRow (constraintsCheckBox)
 */
public class DungeonOptionRow extends OptionRow<DungeonResultRow> implements HasConstraintPanel {

  private static final int JLABEL_SIZE = MathUtils.maxLength(Arrays.asList(EDungeonType.values()));
  private final String name;

  private final JLabel infoLabel;

  private final JPanel constraintsCheckBoxPanel;
  private final JCheckBox constraintsCheckBox;
  private final JLabel constraintsCheckBoxLabel;

  private final ConstraintPanel constraintPanel;

  private final ConstraintPanel basicOptionsPanel;

  private final ConstraintPanel nbRoomsDesiredPanel;
  private final JSpinner nbRoomsDesiredSpinner;
  private final SpinnerNumberModel nbRoomsDesiredModel;
  private final JLabel nbRoomsDesiredLabel;

  private final JButton generateDungeonButton;

  private final JButton saveDungeonButton;

  private DungeonController dungeonController;

  public DungeonOptionRow(IAvailableDungeon availableDungeon) {
    super();

    name = availableDungeon.getName();
    infoLabel = new JLabel(StringUtils.leftAlign(JLABEL_SIZE, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    constraintsCheckBoxLabel = new JLabel("Options");
    constraintsCheckBoxLabel.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBox = new JCheckBox();
    constraintsCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    constraintsCheckBoxPanel = new JPanel();
    constraintsCheckBoxPanel.setLayout(new BoxLayout(constraintsCheckBoxPanel, BoxLayout.Y_AXIS));
    constraintsCheckBoxPanel.add(constraintsCheckBoxLabel);
    constraintsCheckBoxPanel.add(constraintsCheckBox);
    add(constraintsCheckBoxPanel);

    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));

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
    add(constraintPanel);

    // generate button
    generateDungeonButton = new JButton("Generate");
    generateDungeonButton.setToolTipText("Generate a random " + name);
    add(generateDungeonButton);

    // TODO : move to result row?
    saveDungeonButton = new JButton("Save");
    saveDungeonButton.setToolTipText("Save the dungeon as an image");
    saveDungeonButton.setEnabled(false);
    add(saveDungeonButton);

    updateConstraintsAbility(false);
  }

  @Override
  public void setControllers(DungeonResultRow dungeonResultRow) {
    dungeonController = new DungeonController(this, dungeonResultRow);
    constraintsCheckBox.addItemListener(dungeonController.getConstraintsItemListener());
    generateDungeonButton.addActionListener(dungeonController.getGenerateDungeonActionListener());
    saveDungeonButton.addActionListener(dungeonController.getSaveDungeonActionListener());
  }

  public void setEnabledSaveButton(boolean b) {
    saveDungeonButton.setEnabled(b);
  }

  @Override
  public boolean isConstraintsCheckBoxSelected() {
    return constraintsCheckBox.isSelected();
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    constraintPanel.setEnabled(checkBoxSelected);
  }

  public int getNbRoomsDesired() {
    return nbRoomsDesiredModel.getNumber().intValue();
  }
}
