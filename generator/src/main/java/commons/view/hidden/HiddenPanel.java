package commons.view.hidden;

import commons.model.commons.Game;
import org.jetbrains.annotations.NonNls;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by Germain on 24/07/2016.
 */
public class HiddenPanel<T extends Game> extends JPanel {

  private final JLabel iconLabel;

  public HiddenPanel(T game) {
    iconLabel = new JLabel();
    @NonNls String name = "/images/" + game.getName() + ".png";
    iconLabel.setIcon(new ImageIcon(getClass().getResource(name)));
    add(iconLabel);
  }
}
