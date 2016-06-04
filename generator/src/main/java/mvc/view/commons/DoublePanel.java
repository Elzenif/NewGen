package mvc.view.commons;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Germain on 04/06/2016.
 */
public abstract class DoublePanel extends JPanel {

  protected final JPanel leftPanel;
  protected final JPanel rightPanel;

  public DoublePanel(JPanel leftPanel, JPanel rightPanel) {
    this.leftPanel = leftPanel;
    this.rightPanel = rightPanel;

    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    setPanelsComponents();
    add(this.leftPanel);
    add(this.rightPanel);
  }

  protected static JPanel setPanel(String title, int nb_rows, int nb_cols) {
    JPanel jPanel = new JPanel(new GridLayout(nb_rows, nb_cols, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    jPanel.setBorder(BorderFactory.createTitledBorder(title));
    return jPanel;
  }

  protected abstract void setPanelsComponents();

}
