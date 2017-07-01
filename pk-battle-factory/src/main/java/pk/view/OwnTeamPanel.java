package pk.view;

import commons.Constants;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OwnTeamPanel extends TeamPanel {

  public OwnTeamPanel() {
    super(Constants.resourceBundle.getString("panel.team.own"));

    for (int i = 0; i < 3; i++) {
      add(new PkInfoRow());
    }
  }
}
