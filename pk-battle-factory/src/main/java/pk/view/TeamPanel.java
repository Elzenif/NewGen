package pk.view;

import commons.Constants;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
public abstract class TeamPanel extends JPanel {

  public TeamPanel(String title) {
    setLayout(new GridLayout(3, 1, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP / 2));
    setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.DEFAULT_JUSTIFICATION,
        TitledBorder.DEFAULT_POSITION, Constants.BENGUIAB_FONT));
  }
}
