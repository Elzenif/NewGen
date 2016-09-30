package commons.view.utils;

import commons.view.commons.Result;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Image;

/**
 * Created by Germain on 24/09/2016.
 */
public class GraphResultRow<T extends Result<Image>> extends ResultRow<T, Image> {

  private JScrollPane scrollPane;
  private JLabel resultToPrint;

  protected GraphResultRow() {
    super();
  }

  @Override
  public void clearResults() {
    if (scrollPane != null) {
      remove(scrollPane);
    }
  }

  public void printGraph(T graphToPrint) {
    resultToPrint = new JLabel(new ImageIcon(graphToPrint.getRawResult()));
    scrollPane = new JScrollPane(resultToPrint);
    add(scrollPane);
    repaint();
    revalidate();
  }
}
