package commons.view.utils;

import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 05/06/2016.
 */
abstract class PanelRow extends JPanel {

  PanelRow(int hGap, int vGap) {
    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, hGap, vGap);
    flowLayout.setAlignOnBaseline(true);
    setLayout(flowLayout);
  }
}
