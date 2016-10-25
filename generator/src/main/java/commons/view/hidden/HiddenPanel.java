package commons.view.hidden;

import commons.model.commons.Game;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.URL;

/**
 * Created by Germain on 24/07/2016.
 */
public class HiddenPanel<T extends Game> extends JPanel {

  private static final Logger LOGGER = LoggerFactory.getLogger(HiddenPanel.class);

  private final JLabel iconLabel;

  public HiddenPanel(T game) {
    iconLabel = new JLabel();
    @NonNls String name = "/images/" + game.getName() + ".png";
    URL resource = getClass().getResource(name);
    if (resource == null) {
      LOGGER.warn(name + " not found in resources");
    } else {
      iconLabel.setIcon(new ImageIcon(resource));
      add(iconLabel);
    }
  }
}
