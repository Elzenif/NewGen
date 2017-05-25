package commons.view.commons.results;

import commons.utils.StringUtils;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class StringResultRow<T extends StringResult> extends BorderLayoutResultRow<T, String> {

  private final List<JComponent> resultsToPrint;
  private final boolean separateResultsWithComa;

  protected StringResultRow(String labelText, boolean separateResultsWithComa, int hGap, int vGap) {
    super(hGap, vGap, new JLabel(labelText + " : "));

    leftPanel.add(infoLabel);

    resultsToPrint = new LinkedList<>();

    this.separateResultsWithComa = separateResultsWithComa;
  }

  @Override
  public void clearResults() {
    resultsToPrint.forEach(centerPanel::remove);
    resultsToPrint.clear();
  }

  @Override
  public void setResultsToPrint(Collection<T> results) {
    int i = 1;
    int size = results.size();
    for (T result : results) {
      Iterable<String> split = StringUtils.split(result.getRawResult());
      for (String s : split) {
        JLabel resultToPrint = new JLabel(s);
        makePretty(resultToPrint, result);
        resultsToPrint.add(resultToPrint);
        centerPanel.add(resultToPrint);
      }
      if (separateResultsWithComa && i != size) {
        i++;
        JLabel comaLabel = new JLabel(", ");
        makePretty(comaLabel, result);
        resultsToPrint.add(comaLabel);
        centerPanel.add(comaLabel);
      }
    }
    repaint();
    revalidate();
  }

  private void makePretty(JLabel resultToPrint, T result) {
    resultToPrint.setFont(result.getFont());
    resultToPrint.setForeground(result.getColor());
  }

}
