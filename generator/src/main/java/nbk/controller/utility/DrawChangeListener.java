package nbk.controller.utility;

import commons.controller.intf.HasDrawKeysController;
import nbk.model.commons.IDrawKey;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Germain on 01/10/2016.
 */
public class DrawChangeListener<K extends IDrawKey>
    implements ChangeListener {

  private final HasDrawKeysController<K> controller;
  private final K drawKey;

  public DrawChangeListener(HasDrawKeysController<K> controller, K drawKey) {
    this.controller = controller;
    this.drawKey = drawKey;
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    controller.updateDrawKeyValue(drawKey);
  }
}
