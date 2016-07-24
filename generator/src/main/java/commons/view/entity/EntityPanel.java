package commons.view.entity;

import commons.controller.intf.Controller;
import commons.utils.CollectionUtils;
import commons.view.MainFrame;
import commons.view.commons.EGame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends JPanel implements Controller {

  private final CardLayout cardLayout;
  private final Set<EntityPanelEmbedded> gamePanels;
  public EntityPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);
    gamePanels = CollectionUtils.setMaxSizeSet(new HashSet<>(), EGame.NB_GAMES);

    Arrays.stream(EGame.values()).forEach(eGame -> {
      EntityPanelEmbedded panelEmbedded = eGame.getEntityPanelEmbedded();
      gamePanels.add(panelEmbedded);
      add(eGame.getGame().getName(), panelEmbedded);
    });

    cardLayout.show(this, EGame.getDefault().getName());
  }

  @Override
  public void setControllers(MainFrame view) {
    gamePanels.forEach(panelEmbedded -> panelEmbedded.setControllers(view));
  }


}
