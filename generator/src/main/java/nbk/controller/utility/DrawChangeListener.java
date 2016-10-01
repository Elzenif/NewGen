package nbk.controller.utility;

import commons.controller.utility.UtilityController;
import commons.model.commons.Game;
import commons.model.utility.IUtilityDrawKey;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Germain on 01/10/2016.
 */
public class DrawChangeListener<G extends Game, K extends IUtilityDrawKey>
    implements ChangeListener {

  private final UtilityController<G, K> utilityController;
  private final K drawKey;

  public DrawChangeListener(UtilityController<G, K> utilityController, K drawKey) {
    this.utilityController = utilityController;
    this.drawKey = drawKey;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    utilityController.updateDrawKeyValue(drawKey);
  }
}
