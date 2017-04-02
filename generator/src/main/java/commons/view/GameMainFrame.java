package commons.view;

import commons.controller.MainFrameWindowListener;
import commons.controller.intf.Controller;
import commons.view.commons.game.GameTabbedPanel;
import commons.view.menu.MenuBar;
import org.jetbrains.annotations.NonNls;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 07/05/2016.
 */
public class GameMainFrame extends AMainFrame {

  @NonNls
  private static final String GUI_PROP_FILE = "gui.properties";
  private final List<Controller<GameMainFrame>> controllers = new ArrayList<>();
  private MenuBar menuBar;
  private GameTabbedPanel tabbedPane;

  public GameMainFrame() {
    setUpUIComponents();
    setControllers();

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    manageOptionFile(new File(GUI_PROP_FILE));

    setResizable(true);
    setVisible(true);
  }

  @Override
  public String getGuiPropFile() {
    return GUI_PROP_FILE;
  }

  private void setUpUIComponents() {
    Container container = getContentPane();

    List<Image> imageIcons = IntStream.of(16, 32, 64, 128).boxed()
        .map(size -> "/images/Logo-" + size + ".png")
        .map(name -> new ImageIcon(getClass().getResource(name)))
        .map(ImageIcon::getImage)
        .collect(Collectors.toList());
    setIconImages(imageIcons);

    menuBar = new MenuBar();
    setJMenuBar(menuBar);
    controllers.add(menuBar);

    tabbedPane = new GameTabbedPanel();
    controllers.addAll(tabbedPane.getControllers());

    container.add(tabbedPane);
  }

  private void setControllers() {
    addWindowListener(new MainFrameWindowListener(this));
    controllers.forEach(controller -> controller.setControllers(this));
  }

  public GameTabbedPanel getGameTabbedPanel() {
    return tabbedPane;
  }
}
