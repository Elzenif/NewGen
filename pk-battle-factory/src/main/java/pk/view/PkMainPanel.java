package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainPanel extends JSplitPane {

  private final OwnTeamPanel ownTeamPanel;
  private final OpponentTeamPanel opponentTeamPanel;
  private final PkInfoTable pkInfoTable;

  @Autowired
  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel, PkInfoTable pkInfoTable,
                     NewLineButton newLineButton, JButton saveButton) {
    super(VERTICAL_SPLIT);
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
    this.pkInfoTable = pkInfoTable;

    JPanel superiorPanel = new JPanel(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    superiorPanel.add(ownTeamPanel);
    superiorPanel.add(opponentTeamPanel);

    JPanel leftButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    leftButtonPanel.add(newLineButton);
    JPanel rightButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    rightButtonPanel.add(saveButton);

    JPanel bottomPanel = new JPanel();
    BoxLayout boxLayout2 = new BoxLayout(bottomPanel, BoxLayout.Y_AXIS);
    bottomPanel.setLayout(boxLayout2);

    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP / 2));
    buttonPanel.add(leftButtonPanel);
    buttonPanel.add(rightButtonPanel);
    bottomPanel.add(buttonPanel);

    JScrollPane scrollPane = new JScrollPane(pkInfoTable);
    pkInfoTable.setFillsViewportHeight(true);
    bottomPanel.add(scrollPane);

    setTopComponent(superiorPanel);
    setBottomComponent(bottomPanel);
  }
}
