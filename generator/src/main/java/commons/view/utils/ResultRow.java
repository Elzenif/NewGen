package commons.view.utils;

import commons.model.commons.Result;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class ResultRow<T extends Result> extends PanelRow {

  private final JLabel infoLabel;
  private final List<JLabel> resultsToPrint;

  protected ResultRow(String labelText) {
    super(Constants.JPANEL_HGAP / 2, Constants.JPANEL_VGAP);

    infoLabel = new JLabel(labelText + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    resultsToPrint = new LinkedList<>();
  }

  public void clearResults() {
    resultsToPrint.forEach(this::remove);
    resultsToPrint.clear();
  }

  public void setResultsToPrint(Collection<T> results) {
    JLabel separatorLabel = new JLabel("|");
    for (T result: results) {
      JLabel resultToPrint = new JLabel(result.getRawResult());
      makePretty(resultToPrint, result);
      resultsToPrint.add(resultToPrint);
      add(resultToPrint);
      separatorLabel = new JLabel("|");
      resultsToPrint.add(separatorLabel);
      add(separatorLabel);
    }
    remove(separatorLabel);
    repaint();
    revalidate();
  }

  private void makePretty(JLabel resultToPrint, T result) {
    resultToPrint.setFont(result.getFont());
    resultToPrint.setForeground(result.getColor());
  }

}
