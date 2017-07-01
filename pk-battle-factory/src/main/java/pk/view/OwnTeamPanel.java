package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class OwnTeamPanel extends TeamPanel {

  private final PkInfoRow pkInfoRow1;
  private final PkInfoRow pkInfoRow2;
  private final PkInfoRow pkInfoRow3;

  @Autowired
  public OwnTeamPanel(@Qualifier("pkInfoRow1") PkInfoRow pkInfoRow1,
                      @Qualifier("pkInfoRow2") PkInfoRow pkInfoRow2,
                      @Qualifier("pkInfoRow3") PkInfoRow pkInfoRow3) {
    super(Constants.resourceBundle.getString("panel.team.own"));
    this.pkInfoRow1 = pkInfoRow1;
    this.pkInfoRow2 = pkInfoRow2;
    this.pkInfoRow3 = pkInfoRow3;

    add(pkInfoRow1);
    add(pkInfoRow2);
    add(pkInfoRow3);
  }
}
