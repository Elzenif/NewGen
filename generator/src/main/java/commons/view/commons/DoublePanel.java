package commons.view.commons;

import commons.Constants;
import commons.controller.intf.Controller;
import commons.utils.CollectionUtils;
import commons.utils.Pair;
import commons.view.MainFrame;
import commons.view.commons.options.OptionRow;
import commons.view.commons.results.ResultRow;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class DoublePanel<O extends JPanel & OptionRow<R>, R extends JPanel & ResultRow>
    extends JPanel implements Controller<MainFrame> {

  private final Set<Pair<O, R>> rowPairs;
  private final JPanel leftPanel;
  private final JPanel rightPanel;

  protected DoublePanel(IAvailableRow<O, R>[] availableRows) {
    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    leftPanel = setPanel(resourceBundle.getString("panel.options"), availableRows.length);
    rightPanel = setPanel(resourceBundle.getString("panel.results"), availableRows.length);

    rowPairs = CollectionUtils.setMaxSizeSet(new HashSet<>(), availableRows.length);

    for (IAvailableRow<O, R> availableRow : availableRows) {
      O optionRow = availableRow.getOptionRow();
      R resultRow = availableRow.getResultRow();
      rowPairs.add(new Pair<>(optionRow, resultRow));
      leftPanel.add(optionRow);
      rightPanel.add(resultRow);
    }
    add(leftPanel);
    add(rightPanel);
  }

  private static JPanel setPanel(String title, int nb_rows) {
    JPanel jPanel = new JPanel(new GridLayout(nb_rows, 1, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    jPanel.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.DEFAULT_JUSTIFICATION,
        TitledBorder.DEFAULT_POSITION, Constants.BENGUIAB_FONT));
    return jPanel;
  }

  @Override
  public void setControllers(MainFrame mainFrame) {
    rowPairs.forEach(rowPair -> rowPair.getLeft().setControllers(rowPair.getRight()));
  }
}
