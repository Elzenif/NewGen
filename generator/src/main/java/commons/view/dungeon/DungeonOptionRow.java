package commons.view.dungeon;

import commons.controller.dungeon.GenerateDungeonActionListener;
import commons.model.dungeon.EDungeonType;
import commons.model.dungeon.IAvailableDungeon;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.OptionRow;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Arrays;

/**
 * Created by Germain on 24/09/2016.
 */
public class DungeonOptionRow extends OptionRow<DungeonResultRow> {

  private static final int JLABEL_SIZE = MathUtils.maxLength(Arrays.asList(EDungeonType.values()));
  private final String name;

  private JLabel infoLabel;

  private JButton generateDungeonButton;

  public DungeonOptionRow(IAvailableDungeon availableDungeon) {
    super();

    name = availableDungeon.getName();
    infoLabel = new JLabel(StringUtils.leftAlign(JLABEL_SIZE, name));
    add(infoLabel);

    generateDungeonButton = new JButton("Generate");
    generateDungeonButton.setToolTipText("Generate a random " + name);
    add(generateDungeonButton);
  }

  @Override
  public void setControllers(DungeonResultRow dungeonResultRow) {
    generateDungeonButton.addActionListener(new GenerateDungeonActionListener(this, dungeonResultRow));
  }
}
