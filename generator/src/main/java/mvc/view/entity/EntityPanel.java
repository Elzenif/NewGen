package mvc.view.entity;

import mvc.controller.intf.Controller;
import mvc.model.entity.enums.EGame;
import mvc.view.MainFrame;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends JPanel implements Controller {

  private final CardLayout cardLayout;
  private final Map<EGame, EntityPanelEmbedded> gamePanels = new HashMap<>(EGame.values().length);

  public EntityPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);

    for (EGame game : EGame.values()) {
      EntityPanelEmbedded panelEmbedded = new EntityPanelEmbedded(game);
      gamePanels.put(game, panelEmbedded);
      add(game.getName(), panelEmbedded);
    }
    cardLayout.show(this, EGame.defaultGame().getName());
  }

  @Override
  public void setControllers(MainFrame view) {
    gamePanels.values().stream().forEach(panelEmbedded -> panelEmbedded.setControllers(view));
  }
}
