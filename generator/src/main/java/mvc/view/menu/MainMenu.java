package mvc.view.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by Germain on 05/05/2016.
 */
public class MainMenu extends JMenuBar {

  private JMenu gameMenu;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JRadioButtonMenuItem rbNoGame;
  private JRadioButtonMenuItem rbNaheulbeuk;

  public MainMenu() {
    setGameMenu();
  }

  private void setGameMenu() {
    gameMenu = new JMenu("Game");
    gameMenu.setMnemonic(KeyEvent.VK_G);

    rbNoGame = new JRadioButtonMenuItem("No game", true);
    rbNoGame.setMnemonic(KeyEvent.VK_0);
    buttonGroup.add(rbNoGame);
    gameMenu.add(rbNoGame);

    rbNaheulbeuk = new JRadioButtonMenuItem("Naheulbeuk");
    rbNaheulbeuk.setMnemonic(KeyEvent.VK_N);
    buttonGroup.add(rbNaheulbeuk);
    gameMenu.add(rbNaheulbeuk);

    add(gameMenu);
  }
}
