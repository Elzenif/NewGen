package mvc.view.commons;

import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class PanelRow extends JPanel {

  protected PanelRow() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }
}
