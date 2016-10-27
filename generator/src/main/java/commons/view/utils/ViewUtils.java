package commons.view.utils;

import org.jetbrains.annotations.Nullable;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Component;

/**
 * Created by Germain on 27/10/2016.
 */
public class ViewUtils {

  public static ConstraintPanel createSpinnerWithLabelOnTop(String label, JSpinner jSpinner, @Nullable String toolTip) {
    ConstraintPanel cPanel = new ConstraintPanel();
    cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));

    JLabel jLabel = new JLabel(label);
    jLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

    jSpinner.setAlignmentX(Component.LEFT_ALIGNMENT);
    jSpinner.setMaximumSize(jSpinner.getPreferredSize());
    if (toolTip != null) {
      jSpinner.setToolTipText(toolTip);
    }

    cPanel.add(jLabel);
    cPanel.add(jSpinner);

    return cPanel;
  }

}
