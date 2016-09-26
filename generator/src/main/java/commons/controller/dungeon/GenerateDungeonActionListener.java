package commons.controller.dungeon;

import commons.model.dungeon.Dungeon;
import commons.view.dungeon.DungeonOptionRow;
import commons.view.dungeon.DungeonResultRow;
import commons.view.dungeon.results.DungeonResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 24/09/2016.
 */
public class GenerateDungeonActionListener implements ActionListener {

  private final DungeonOptionRow dungeonOptionRow;
  private final DungeonResultRow dungeonResultRow;

  public GenerateDungeonActionListener(DungeonOptionRow dungeonOptionRow, DungeonResultRow dungeonResultRow) {
    this.dungeonOptionRow = dungeonOptionRow;
    this.dungeonResultRow = dungeonResultRow;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    dungeonResultRow.clearResults();
    Dungeon dungeon = new Dungeon(10, 2);
    DungeonResult dungeonResult = new DungeonResult(dungeon);
    dungeonResultRow.printGraph(dungeonResult);
  }
}
