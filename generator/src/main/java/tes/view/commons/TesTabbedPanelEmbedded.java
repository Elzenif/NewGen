package tes.view.commons;

import commons.view.commons.GameTabbedPanelEmbedded;
import commons.view.dice.DicePanel;
import commons.view.hidden.HiddenPanelEmbedded;
import tes.model.commons.TesGame;

/**
 * Created by Germain on 24/07/2016.
 */
public class TesTabbedPanelEmbedded extends GameTabbedPanelEmbedded<TesGame> {

  private final HiddenPanelEmbedded<TesGame> hiddenPanel;
  private final DicePanel dicePanel;

  public TesTabbedPanelEmbedded() {
    hiddenPanel = new HiddenPanelEmbedded<>(TesGame.getInstance());
    panelMap.put("Hidden", hiddenPanel);

    dicePanel = new DicePanel();
    controllers.add(dicePanel);
    panelMap.put("Dice", dicePanel);

    addPanels();
  }
}
