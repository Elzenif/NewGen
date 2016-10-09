package commons.view.commons.results;

import commons.view.utils.Constants;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Collection;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class GraphResultRow<T extends Result<Image>> extends JPanel implements ResultRow<T, Image> {

  protected final JPanel optionRow;

  private JScrollPane scrollPane;
  private JLabel resultToPrint;

  protected GraphResultRow() {
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    setLayout(layout);

    optionRow = new JPanel(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));
    add(optionRow);

    scrollPane = new JScrollPane();
    add(scrollPane);
  }

  @Override
  public void clearResults() {
    if (scrollPane != null) {
      remove(scrollPane);
    }
  }

  @Override
  public void setResultsToPrint(Collection<T> results) {
    for (T result : results) {
      resultToPrint = new JLabel(new ImageIcon(result.getRawResult()));
      scrollPane = new JScrollPane(resultToPrint);
      add(scrollPane);
      repaint();
      revalidate();
    }
  }
}
