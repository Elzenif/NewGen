package commons.view.utils;

import commons.utils.StringUtils;
import commons.view.commons.StringResult;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class StringResultRow<T extends StringResult> extends ResultRow<T, String> {

  private final JLabel infoLabel;
  private final List<JLabel> resultsToPrint;

  protected StringResultRow(String labelText) {
    super();

    infoLabel = new JLabel(labelText + " : ");
    infoLabel.setFont(new Font(Constants.FONT_NAME, Font.BOLD, Constants.FONT_SIZE));
    add(infoLabel);

    resultsToPrint = new LinkedList<>();
  }

  @Override
  public void clearResults() {
    resultsToPrint.forEach(this::remove);
    resultsToPrint.clear();
  }

  @Override
  public void setResultsToPrint(Collection<T> results) {
    for (T result : results) {
      Iterable<String> split = StringUtils.split(result.getRawResult());
      for (String s : split) {
        JLabel resultToPrint = new JLabel(s);
        makePretty(resultToPrint, result);
        resultsToPrint.add(resultToPrint);
        add(resultToPrint);
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
