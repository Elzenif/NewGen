package nbk.controller.utility;

import commons.controller.intf.HasDrawKeysController;
import commons.model.commons.IDrawKey;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 01/10/2016.
 */
public class DrawChangeListener<K extends IDrawKey>
    implements ChangeListener, ActionListener {

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

  @Override
  public void actionPerformed(ActionEvent e) {
    controller.updateDrawKeyValue(drawKey);
  }
}
