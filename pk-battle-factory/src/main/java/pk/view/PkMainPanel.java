package pk.view;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalSplitPanel;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainPanel extends VerticalSplitPanel {

  @Autowired
  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel, PkInfoGrid pkInfoGrid,
                     NewLineButton newLineButton, LevelSpinner levelSpinner,
                     IVSpinner ivSpinner) {

    HorizontalSplitPanel superiorPanel = new HorizontalSplitPanel();
    superiorPanel.setFirstComponent(ownTeamPanel);
    superiorPanel.setSecondComponent(opponentTeamPanel);

    JPanel leftButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    leftButtonPanel.add(new JLabel("IV"));
    leftButtonPanel.add(ivSpinner);
    leftButtonPanel.add(new JLabel(Constants.resourceBundle.getString("level")));
    leftButtonPanel.add(levelSpinner);
    leftButtonPanel.add(newLineButton);

    JPanel bottomPanel = new JPanel();
    BoxLayout boxLayout2 = new BoxLayout(bottomPanel, BoxLayout.Y_AXIS);
    bottomPanel.setLayout(boxLayout2);

//    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP / 2));
//    buttonPanel.add(leftButtonPanel);
//    buttonPanel.add(rightButtonPanel);
//    bottomPanel.add(buttonPanel);

//    JScrollPane scrollPane = new JScrollPane(pkInfoGrid);
//    pkInfoGrid.setFillsViewportHeight(true);
//    bottomPanel.add(scrollPane);

    setFirstComponent(superiorPanel);
    setSecondComponent(pkInfoGrid);
  }
}
