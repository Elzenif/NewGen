package mvc.view.entity;

import mvc.controller.intf.Controller;
import mvc.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.*;

import static utils.CollectionUtils.setMaxSize;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends JPanel implements Controller {

  private final CardLayout cardLayout;
  private final List<EntityPanelEmbedded> gamePanels;
  public EntityPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);
    gamePanels = setMaxSize(new ArrayList<>(), EGame.NB_GAMES);

    Arrays.asList(EGame.values()).stream().forEach(eGame -> {
      EntityPanelEmbedded panelEmbedded = eGame.getEntityPanelEmbedded();
      gamePanels.add(panelEmbedded);
      add(eGame.getGame().getName(), panelEmbedded);
    });

    cardLayout.show(this, EGame.getDefault().getName());
  }

  @Override
  public void setControllers(MainFrame view) {
    gamePanels.stream().forEach(panelEmbedded -> panelEmbedded.setControllers(view));
  }


}
