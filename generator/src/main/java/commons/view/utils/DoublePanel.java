package commons.view.utils;

import commons.controller.intf.Controller;
import commons.utils.Pair;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class DoublePanel<O extends OptionRow<R>, R extends ResultRow> extends JPanel implements Controller {

  protected JPanel leftPanel;
  protected JPanel rightPanel;

  private DoublePanel() {
    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }

  protected DoublePanel(JPanel leftPanel, JPanel rightPanel) {
    this();
    this.leftPanel = leftPanel;
    this.rightPanel = rightPanel;
  }

  public JPanel getLeftPanel() {
    return leftPanel;
  }

  public JPanel getRightPanel() {
    return rightPanel;
  }

  protected static JPanel setPanel(String title, int nb_rows) {
    JPanel jPanel = new JPanel(new GridLayout(nb_rows, 1, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    jPanel.setBorder(BorderFactory.createTitledBorder(title));
    return jPanel;
  }

  protected void setControllers(List<Pair<O, R>> rowPairs) {
    rowPairs.forEach(rowPair -> rowPair.getLeft().setControllers(rowPair.getRight()));
  }
}
