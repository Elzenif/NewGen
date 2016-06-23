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
    super();

    infoLabel = new JLabel(labelText + " : ");
    infoLabel.setFont(new Font(null, Font.BOLD, 12));
    add(infoLabel);

    resultsToPrint = new LinkedList<>();
  }

  public void clearResults() {
    resultsToPrint.forEach(this::remove);
    resultsToPrint.clear();
  }

  @SuppressWarnings("unchecked")
  public void setResultsToPrint(Collection<T> results) {
    for (Result result: results) {
      JLabel resultToPrint = new JLabel(result.getRawResult());
      makePretty(resultToPrint, (T) result);
      resultsToPrint.add(resultToPrint);
      add(resultToPrint);
    }
    repaint();
    revalidate();
  }

  protected abstract void makePretty(JLabel resultToPrint, T result);

}
