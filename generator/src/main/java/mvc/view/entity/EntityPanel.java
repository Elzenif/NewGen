package mvc.view.entity;

import mvc.model.entity.enums.EAvailableItem;
import mvc.model.entity.enums.EGame;
import mvc.view.MainFrame;
import mvc.view.commons.DoublePanel;
import mvc.view.entity.nbk.NbkEntityOptionRow;
import utils.Pair;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends DoublePanel<EntityOptionRow, EntityResultRow> {

  private final Map<EGame, JPanel> gamePanels = new HashMap<>(EGame.values().length);

  private final Map<EGame, List<Pair<EntityOptionRow, EntityResultRow>>> rowPairsMap = new HashMap<>(EGame.values().length);

  public EntityPanel() {
    super();
    leftPanel = new JPanel(new CardLayout());
    rightPanel = new JPanel(new CardLayout());

    setPanelsComponents();
    add(leftPanel);
    add(rightPanel);
    ((CardLayout) leftPanel.getLayout()).show(leftPanel, EGame.defaultGame().getName());
    ((CardLayout) rightPanel.getLayout()).show(rightPanel, EGame.defaultGame().getName());
  }

  private void setPanelsComponents() {
    for (EGame game : EGame.values()) {
      List<Pair<EntityOptionRow, EntityResultRow>> rowPairs = new ArrayList<>(EAvailableItem.values().length);
      JPanel gameOptionPanel = setPanel("Options : " + game.getName(), EAvailableItem.values().length);
      JPanel gameResultPanel = setPanel("Results : " + game.getName(), EAvailableItem.values().length);
      for (EAvailableItem availableItem : EAvailableItem.values()) {
        EntityOptionRow entityOptionRow = new NbkEntityOptionRow(availableItem);
        EntityResultRow entityResultRow = new EntityResultRow(availableItem);
        rowPairs.add(new Pair<>(entityOptionRow, entityResultRow));
        gameOptionPanel.add(entityOptionRow);
        gameResultPanel.add(entityResultRow);
      }
      rowPairsMap.put(game, rowPairs);
      leftPanel.add(game.getName(), gameOptionPanel);
      rightPanel.add(game.getName(), gameResultPanel);
    }
  }

  @Override
  public void setControllers(MainFrame view) {
    rowPairsMap.keySet().stream().forEach(eGame -> setControllers(rowPairsMap.get(eGame)));
  }
}
