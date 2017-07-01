package pk.view;

import commons.Constants;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainPanel extends JPanel {

  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel) {
    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    add(ownTeamPanel);
    add(opponentTeamPanel);
  }
}
