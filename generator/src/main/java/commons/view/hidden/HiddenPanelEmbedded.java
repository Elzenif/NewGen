package commons.view.hidden;

import commons.model.commons.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class HiddenPanelEmbedded extends JPanel {

  private final JLabel iconLabel;

  public HiddenPanelEmbedded(Game game) {
    iconLabel = new JLabel();
    iconLabel.setIcon(new ImageIcon(getClass().getResource("/images/" + game.getName() + ".png")));
    add(iconLabel);
  }
}
