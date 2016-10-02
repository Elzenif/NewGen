package commons.controller.dungeon;

import commons.view.dungeon.DungeonOptionRow;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Germain on 27/09/2016.
 */
public class SaveDungeonActionListener implements ActionListener {

  private final DungeonController dungeonController;
  private final DungeonOptionRow dungeonOptionRow;
  private final JFileChooser fileChooser;

  public SaveDungeonActionListener(DungeonController dungeonController, DungeonOptionRow dungeonOptionRow) {
    this.dungeonController = dungeonController;
    this.dungeonOptionRow = dungeonOptionRow;
    this.fileChooser = new JFileChooser();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int returnValue = fileChooser.showSaveDialog(dungeonOptionRow);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      try {
        ImageIO.write(((GenerateDungeonActionListener) dungeonController.getGenerateActionListener())
            .getDungeonResult().getRawResult(), "png", selectedFile);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }
}
