package commons.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.URL;

/**
 * Created by Germain on 02/04/2017.
 */
public class HiddenPanel extends JPanel {

  private static final Logger LOGGER = LoggerFactory.getLogger(HiddenPanel.class);

  private final JLabel iconLabel;

  public HiddenPanel(String path, URL resource) {
    iconLabel = new JLabel();
    if (resource == null) {
      LOGGER.warn(path + " not found in resources");
    } else {
      iconLabel.setIcon(new ImageIcon(resource));
      add(iconLabel);
    }
  }
}
