package commons.controller.map;

import commons.view.map.MapResultRow;
import nbk.view.map.options.NbkDungeonOptionRow;
import org.jetbrains.annotations.NonNls;

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

  private final NbkDungeonOptionRow dungeonOptionRow;
  private final MapResultRow mapResultRow;
  private final JFileChooser fileChooser;

  public SaveMapActionListener(NbkDungeonOptionRow dungeonOptionRow, MapResultRow mapResultRow) {
    this.dungeonOptionRow = dungeonOptionRow;
    this.mapResultRow = mapResultRow;
    this.fileChooser = new JFileChooser();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int returnValue = fileChooser.showSaveDialog(dungeonOptionRow);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      try {
        @NonNls String formatName = "png";
        ImageIO.write(mapResultRow.getResult().getRawResult(), formatName, selectedFile);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }
}
