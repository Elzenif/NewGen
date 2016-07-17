package commons.view.entity;

import commons.controller.intf.Controller;
import commons.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static commons.utils.CollectionUtils.setMaxSize;

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
