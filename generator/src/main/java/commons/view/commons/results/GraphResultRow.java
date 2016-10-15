package commons.view.commons.results;

import commons.view.utils.Constants;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

/**
 * Created by Germain on 24/09/2016.
 */
public abstract class GraphResultRow<T extends Result<Image>> extends JPanel implements ResultRow<T, Image> {

  protected final JPanel optionRow;
  protected final ScrollableLabel resultToPrint;
  private final JScrollPane scrollPane;

  protected GraphResultRow() {
    setLayout(new BorderLayout(Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    optionRow = new JPanel(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP));
    add(optionRow, BorderLayout.NORTH);

    scrollPane = new JScrollPane();
    resultToPrint = new ScrollableLabel();
    scrollPane.setViewportView(resultToPrint);
    add(scrollPane, BorderLayout.CENTER);
  }

  @Override
  public void clearResults() {
    if (scrollPane != null) {
      remove(scrollPane);
    }
  }

  protected void setResultsToPrint(T result) {
    resultToPrint.setIcon(new ImageIcon(result.getRawResult()));
    scrollPane.setViewportView(resultToPrint);
    add(scrollPane);
    repaint();
    revalidate();
  }

  protected void setControllers() {
    resultToPrint.setControllers();
  }
}
