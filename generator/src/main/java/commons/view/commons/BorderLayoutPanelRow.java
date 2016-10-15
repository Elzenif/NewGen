package commons.view.commons;

import org.jetbrains.annotations.NotNull;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

/**
 * Created by Germain on 05/06/2016.
 */
public abstract class BorderLayoutPanelRow extends JPanel {

  protected final FlowLayoutPanelRow leftPanel;
  protected final FlowLayoutPanelRow centerPanel;
  protected final FlowLayoutPanelRow rightPanel;

  protected BorderLayoutPanelRow(int hGap, int vGap) {
    leftPanel = new FlowLayoutPanelRow(hGap / 2, vGap, true);
    centerPanel = new FlowLayoutPanelRow(hGap / 2, vGap, false);
    rightPanel = new FlowLayoutPanelRow(hGap / 2, vGap, true);

    setLayout(new BorderLayout(hGap, vGap));

    super.add(leftPanel, BorderLayout.WEST);
    super.add(centerPanel, BorderLayout.CENTER);
    super.add(rightPanel, BorderLayout.EAST);
  }

  @Override
  public Component add(Component comp) {
    throw new UnsupportedOperationException("Should use " + getClass().getName() + " method to add a component");
  }

  @Override
  public Component add(String name, Component comp) {
    throw new UnsupportedOperationException("Should use " + getClass().getName() + " method to add a component");
  }

  @Override
  public Component add(Component comp, int index) {
    throw new UnsupportedOperationException("Should use " + getClass().getName() + " method to add a component");
  }

  @Override
  public void add(@NotNull Component comp, Object constraints) {
    throw new UnsupportedOperationException("Should use " + getClass().getName() + " method to add a component");
  }

  @Override
  public void add(Component comp, Object constraints, int index) {
    throw new UnsupportedOperationException("Should use " + getClass().getName() + " method to add a component");
  }
}

