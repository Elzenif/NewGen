package pk.controller;

import java.awt.event.ActionListener;

/**
 * Created by Germain on 10/07/2017.
 */
public interface DelayedActionListener extends ActionListener {

  default int getDelay() {
    return 1000;
  }

}
