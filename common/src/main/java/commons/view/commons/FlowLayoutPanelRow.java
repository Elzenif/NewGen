package commons.view.commons;

import javax.swing.JPanel;
import java.awt.FlowLayout;

public class FlowLayoutPanelRow extends JPanel {

  FlowLayoutPanelRow(int hGap, int vGap, boolean alignOnBaseline) {
    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, hGap, vGap);
    flowLayout.setAlignOnBaseline(alignOnBaseline);
    setLayout(flowLayout);
  }
}
