package pk.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    HorizontalLayout buttonLayout = new HorizontalLayout(newLineButton);
//    buttonLayout.add(new JLabel("IV"));
//    buttonLayout.add(ivSpinner);
//    buttonLayout.add(new JLabel(Constants.resourceBundle.getString("level")));
//    buttonLayout.add(levelSpinner);

    VerticalLayout bottomLayout = new VerticalLayout(buttonLayout, pkInfoGrid);

//    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP / 2));
//    buttonPanel.add(buttonLayout);
//    buttonPanel.add(rightButtonPanel);
//    bottomLayout.add(buttonPanel);

//    JScrollPane scrollPane = new JScrollPane(pkInfoGrid);
//    pkInfoGrid.setFillsViewportHeight(true);
//    bottomLayout.add(scrollPane);

    setFirstComponent(superiorPanel);
    setSecondComponent(bottomLayout);
  }
}
