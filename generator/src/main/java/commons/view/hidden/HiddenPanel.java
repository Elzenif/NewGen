package commons.view.hidden;

import commons.utils.CollectionUtils;
import commons.view.entity.EGame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Germain on 24/07/2016.
 */
public class HiddenPanel extends JPanel {

  private final CardLayout cardLayout;
  private final Set<HiddenPanelEmbedded> hiddenPanelEmbeddedSet;

  public HiddenPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);
    hiddenPanelEmbeddedSet = CollectionUtils.setMaxSizeSet(new HashSet<>(), EGame.NB_GAMES);

    Arrays.stream(EGame.values()).forEach(eGame -> {
      HiddenPanelEmbedded panelEmbedded = new HiddenPanelEmbedded(eGame.getGame());
      hiddenPanelEmbeddedSet.add(panelEmbedded);
      add(eGame.getGame().getName(), panelEmbedded);
    });

    cardLayout.show(this, EGame.getDefault().getName());
  }
}
