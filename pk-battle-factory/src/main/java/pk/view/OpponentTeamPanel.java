package pk.view;

import commons.Constants;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OpponentTeamPanel extends TeamPanel {

  public OpponentTeamPanel() {
    super(Constants.resourceBundle.getString("panel.team.opponent"));
  }
}
