package commons.view.utils;

import commons.utils.StringUtils;
import commons.view.commons.StringResult;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class StringResultRow<T extends StringResult> extends ResultRow<T, String> {

  private final JLabel infoLabel;
  private final List<JComponent> resultsToPrint;
  private final boolean separateResultsWithComa;

  protected StringResultRow(String labelText, boolean separateResultsWithComa, int hGap, int vGap) {
    super(hGap, vGap);

    infoLabel = new JLabel(labelText + " : ");
    infoLabel.setFont(Constants.BENGUIAB_FONT);
    add(infoLabel);

    resultsToPrint = new LinkedList<>();

    this.separateResultsWithComa = separateResultsWithComa;
  }

  @Override
  public void clearResults() {
    resultsToPrint.forEach(this::remove);
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
        add(resultToPrint);
      }
      if (separateResultsWithComa && i != size) {
        i++;
        JLabel comaLabel = new JLabel(", ");
        makePretty(comaLabel, result);
        resultsToPrint.add(comaLabel);
        add(comaLabel);
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
