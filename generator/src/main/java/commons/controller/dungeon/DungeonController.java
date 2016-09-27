package commons.controller.dungeon;

import commons.view.dungeon.DungeonOptionRow;
import commons.view.dungeon.DungeonResultRow;

import java.awt.event.ActionListener;

/**
 * Created by Germain on 26/09/2016.
 */
public class DungeonController {

  private GenerateDungeonActionListener generateDungeonActionListener;
  private ActionListener saveDungeonActionListener;

  public DungeonController(DungeonOptionRow dungeonOptionRow, DungeonResultRow dungeonResultRow) {
    generateDungeonActionListener = new GenerateDungeonActionListener(dungeonOptionRow, dungeonResultRow);
    saveDungeonActionListener = new SaveDungeonActionListener(this, dungeonOptionRow);
  }

  public GenerateDungeonActionListener getGenerateDungeonActionListener() {
    return generateDungeonActionListener;
  }

  public ActionListener getSaveDungeonActionListener() {
    return saveDungeonActionListener;
  }
}
