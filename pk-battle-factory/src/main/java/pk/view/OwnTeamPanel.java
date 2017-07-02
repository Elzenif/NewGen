package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JScrollPane;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OwnTeamPanel extends TeamPanel {

  private final PkInfoRow pkInfoRow1;
  private final PkInfoTable pkInfoTable;

  @Autowired
  public OwnTeamPanel(PkInfoRow pkInfoRow1, PkInfoTable pkInfoTable) {
    super(Constants.resourceBundle.getString("panel.team.own"));
    this.pkInfoRow1 = pkInfoRow1;
    this.pkInfoTable = pkInfoTable;

    add(pkInfoRow1);

    JScrollPane scrollPane = new JScrollPane(pkInfoTable);
    pkInfoTable.setFillsViewportHeight(true);
    add(scrollPane);

  }
}
