package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OwnTeamPanel extends TeamPanel {

  @Autowired
  public OwnTeamPanel(PkOwnInfoRow pkOwnInfoRow1, PkOwnInfoRow pkOwnInfoRow2, PkOwnInfoRow pkOwnInfoRow3,
                      PkOwnInfoRow pkOwnInfoRow4, PkOwnInfoRow pkOwnInfoRow5, PkOwnInfoRow pkOwnInfoRow6) {
    super(Constants.resourceBundle.getString("panel.team.own"), 6);

    addComponent(pkOwnInfoRow1);
    addComponent(pkOwnInfoRow2);
    addComponent(pkOwnInfoRow3);
    addComponent(pkOwnInfoRow4);
    addComponent(pkOwnInfoRow5);
    addComponent(pkOwnInfoRow6);
  }
}
