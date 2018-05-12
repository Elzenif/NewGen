package pk.view.main;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OpponentTeamPanel extends TeamPanel<PkOpponentInfoRow> {

  @Autowired
  public OpponentTeamPanel(PkOpponentInfoRow pkOpponentInfoRow1, PkOpponentInfoRow pkOpponentInfoRow2,
                           PkOpponentInfoRow pkOpponentInfoRow3, PkOpponentInfoRow pkOpponentInfoRow4,
                           PkOpponentInfoRow pkOpponentInfoRow5, PkOpponentInfoRow pkOpponentInfoRow6) {
    super(Constants.resourceBundle.getString("panel.team.opponent"), 6);
    add(pkOpponentInfoRow1);
    add(pkOpponentInfoRow2);
    add(pkOpponentInfoRow3);
    add(pkOpponentInfoRow4);
    add(pkOpponentInfoRow5);
    add(pkOpponentInfoRow6);
  }

}
