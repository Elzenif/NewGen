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
  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel, PkInfoTable pkInfoTable) {
    super(VERTICAL_SPLIT);
    this.ownTeamPanel = ownTeamPanel;
    this.opponentTeamPanel = opponentTeamPanel;
    this.pkInfoTable = pkInfoTable;

    JPanel superiorPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(superiorPanel, BoxLayout.Y_AXIS);
    superiorPanel.setLayout(boxLayout);

    JPanel centralPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    centralPanel.add(ownTeamPanel);
    centralPanel.add(opponentTeamPanel);
    superiorPanel.add(centralPanel);

    JPanel leftButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton newLineButton = new JButton(Constants.resourceBundle.getString("newLine"));
    leftButtonPanel.add(newLineButton);
    JPanel rightButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton saveButton = new JButton(Constants.resourceBundle.getString("save"));
    saveButton.setEnabled(false);
    rightButtonPanel.add(saveButton);

    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP / 2));
    buttonPanel.add(leftButtonPanel);
    buttonPanel.add(rightButtonPanel);
    superiorPanel.add(buttonPanel);

    JScrollPane scrollPane = new JScrollPane(pkInfoTable);
    pkInfoTable.setFillsViewportHeight(true);

    setTopComponent(superiorPanel);
    setBottomComponent(scrollPane);
  }
}
