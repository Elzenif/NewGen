package commons.view.dungeon;

import commons.controller.dungeon.DungeonController;
import commons.model.dungeon.EDungeonType;
import commons.model.dungeon.IAvailableDungeon;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.OptionRow;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonOptionRow extends OptionRow<DungeonResultRow> {

  private static final int JLABEL_SIZE = MathUtils.maxLength(Arrays.asList(EDungeonType.values()));
  private final String name;

  private JLabel infoLabel;

  private JButton generateDungeonButton;

  private JButton saveDungeonButton;

  private DungeonController dungeonController;

  public DungeonOptionRow(IAvailableDungeon availableDungeon) {
    super();

    name = availableDungeon.getName();
    infoLabel = new JLabel(StringUtils.leftAlign(JLABEL_SIZE, name) + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    generateDungeonButton = new JButton("Generate");
    generateDungeonButton.setToolTipText("Generate a random " + name);
    add(generateDungeonButton);

    saveDungeonButton = new JButton("Save");
    saveDungeonButton.setToolTipText("Save the dungeon as an image");
    saveDungeonButton.setEnabled(false);
    add(saveDungeonButton);
  }

  @Override
  public void setControllers(DungeonResultRow dungeonResultRow) {
    dungeonController = new DungeonController(this, dungeonResultRow);
    generateDungeonButton.addActionListener(dungeonController.getGenerateDungeonActionListener());
    saveDungeonButton.addActionListener(dungeonController.getSaveDungeonActionListener());
  }

  public void setEnabledSaveButton(boolean b) {
    saveDungeonButton.setEnabled(b);
  }
}
