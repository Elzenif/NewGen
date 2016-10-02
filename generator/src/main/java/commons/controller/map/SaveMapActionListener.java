package commons.controller.map;

import commons.view.map.NbkDungeonOptionRow;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Germain on 27/09/2016.
 */
public class SaveMapActionListener implements ActionListener {

  private final NbkDungeonController dungeonController;
  private final NbkDungeonOptionRow dungeonOptionRow;
  private final JFileChooser fileChooser;

  public SaveMapActionListener(NbkDungeonController dungeonController, NbkDungeonOptionRow dungeonOptionRow) {
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
        ImageIO.write(((GenerateNbkDungeonActionListener) dungeonController.getGenerateActionListener())
            .getDungeonResult().getRawResult(), "png", selectedFile);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }
}
