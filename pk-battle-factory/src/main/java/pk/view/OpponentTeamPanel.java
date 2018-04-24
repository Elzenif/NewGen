package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OpponentTeamPanel extends TeamPanel {

  @Autowired
  public OpponentTeamPanel(PkOpponentInfoRow pkOpponentInfoRow1, PkOpponentInfoRow pkOpponentInfoRow2,
                           PkOpponentInfoRow pkOpponentInfoRow3) {
    super(Constants.resourceBundle.getString("panel.team.opponent"), 3);
    addComponent(pkOpponentInfoRow1);
    addComponent(pkOpponentInfoRow2);
    addComponent(pkOpponentInfoRow3);
  }
}
