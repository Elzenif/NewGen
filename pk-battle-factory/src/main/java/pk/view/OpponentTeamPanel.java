package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OpponentTeamPanel extends TeamPanel {

  private final PkOpponentInfoRow pkOpponentInfoRow1;
  private final PkOpponentInfoRow pkOpponentInfoRow2;
  private final PkOpponentInfoRow pkOpponentInfoRow3;

  @Autowired
  public OpponentTeamPanel(PkOpponentInfoRow pkOpponentInfoRow1, PkOpponentInfoRow pkOpponentInfoRow2,
                           PkOpponentInfoRow pkOpponentInfoRow3) {
    super(Constants.resourceBundle.getString("panel.team.opponent"));
    this.pkOpponentInfoRow1 = pkOpponentInfoRow1;
    this.pkOpponentInfoRow2 = pkOpponentInfoRow2;
    this.pkOpponentInfoRow3 = pkOpponentInfoRow3;

    add(pkOpponentInfoRow1);
    add(pkOpponentInfoRow2);
    add(pkOpponentInfoRow3);
  }
}
