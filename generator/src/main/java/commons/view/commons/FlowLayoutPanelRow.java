package commons.view.commons;

import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class FlowLayoutPanelRow extends JPanel {

  protected FlowLayoutPanelRow(int hGap, int vGap) {
    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, hGap, vGap);
    flowLayout.setAlignOnBaseline(true);
    setLayout(flowLayout);
  }
}
