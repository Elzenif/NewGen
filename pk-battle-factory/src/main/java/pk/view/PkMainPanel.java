package pk.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainPanel extends VerticalSplitPanel {

  @Autowired
  public PkMainPanel(OwnTeamPanel ownTeamPanel, OpponentTeamPanel opponentTeamPanel, PkInfoGrid pkInfoGrid,
                     NewLineButton newLineButton, LevelField levelField, IVField ivField) {
    HorizontalSplitPanel superiorPanel = new HorizontalSplitPanel();
    superiorPanel.setFirstComponent(ownTeamPanel);
    superiorPanel.setSecondComponent(opponentTeamPanel);

    HorizontalLayout buttonLayout = new HorizontalLayout(newLineButton, ivField, levelField);
    buttonLayout.setComponentAlignment(newLineButton, Alignment.BOTTOM_CENTER);
    buttonLayout.setComponentAlignment(ivField, Alignment.BOTTOM_CENTER);
    buttonLayout.setComponentAlignment(levelField, Alignment.BOTTOM_CENTER);

    VerticalLayout bottomLayout = new VerticalLayout(buttonLayout, pkInfoGrid);

    setFirstComponent(superiorPanel);
    setSecondComponent(bottomLayout);
    setSplitPosition(65, Unit.PERCENTAGE);
  }
}
