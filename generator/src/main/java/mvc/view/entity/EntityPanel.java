package mvc.view.entity;

import mvc.controller.intf.Controller;
import mvc.model.entity.game.EGame;
import mvc.model.entity.game.Game;
import mvc.model.entity.game.NbkGame;
import mvc.model.entity.game.TesGame;
import mvc.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

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
    gamePanels = setMaxSize(new ArrayList<>(), Game.NB_GAMES);

    // NBK
    EntityPanelEmbedded panelEmbedded = new NbkEntityPanelEmbedded();
    gamePanels.add(panelEmbedded);
    add(NbkGame.getInstance().getName(), panelEmbedded);
    //TES
    panelEmbedded = new TesEntityPanelEmbedded();
    gamePanels.add(panelEmbedded);
    add(TesGame.getInstance().getName(), panelEmbedded);

    cardLayout.show(this, EGame.getDefault().getName());
  }

  @Override
  public void setControllers(MainFrame view) {
    gamePanels.stream().forEach(panelEmbedded -> panelEmbedded.setControllers(view));
  }


}
