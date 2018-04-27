package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OwnTeamPanel extends TeamPanel<PkOwnInfoRow> {

  @Autowired
  public OwnTeamPanel(PkOwnInfoRow pkOwnInfoRow1, PkOwnInfoRow pkOwnInfoRow2, PkOwnInfoRow pkOwnInfoRow3,
                      PkOwnInfoRow pkOwnInfoRow4, PkOwnInfoRow pkOwnInfoRow5, PkOwnInfoRow pkOwnInfoRow6) {
    super(Constants.resourceBundle.getString("panel.team.own"), 6);

    add(pkOwnInfoRow1);
    add(pkOwnInfoRow2);
    add(pkOwnInfoRow3);
    add(pkOwnInfoRow4);
    add(pkOwnInfoRow5);
    add(pkOwnInfoRow6);
  }
}
