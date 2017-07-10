package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainPanel extends JPanel {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;
  private final PkInfoTable pkInfoTable;

  @Autowired
  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel, PkInfoTable pkInfoTable) {
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
    this.pkInfoTable = pkInfoTable;

    setLayout(new BorderLayout(Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    JPanel centralPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    centralPanel.add(ownTeamPanel);
    centralPanel.add(opponentTeamPanel);

    add(centralPanel, BorderLayout.CENTER);

    JScrollPane scrollPane = new JScrollPane(pkInfoTable);
    pkInfoTable.setFillsViewportHeight(true);
    add(scrollPane, BorderLayout.PAGE_END);
  }
}
