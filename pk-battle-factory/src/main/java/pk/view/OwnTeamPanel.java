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
  public OwnTeamPanel(PkOwnInfoRow pkOwnInfoRow1, PkOwnInfoRow pkOwnInfoRow2, PkOwnInfoRow pkOwnInfoRow3) {
    super(Constants.resourceBundle.getString("panel.team.own"));
    add(pkOwnInfoRow1);
    add(pkOwnInfoRow2);
    add(pkOwnInfoRow3);
  }
}
