package pk.view;

import commons.controller.MainFrameWindowListener;
import commons.controller.intf.Controller;
import commons.view.AMainFrame;
import org.jetbrains.annotations.NonNls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.menu.MenuBar;

import javax.swing.JFrame;
import java.io.File;
import java.util.List;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainFrame extends AMainFrame {

  @NonNls
  private static final String GUI_PROP_FILE = "gui.properties";
  private List<Controller<PkMainFrame>> controllers;

  @Autowired
  public PkMainFrame(MenuBar menuBar, PkMainPanel pkMainPanel) {
    setJMenuBar(menuBar);
    getContentPane().add(pkMainPanel);

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    manageOptionFile(new File(GUI_PROP_FILE));
    addWindowListener(new MainFrameWindowListener(this));

    setResizable(true);
  }

  @Autowired(required = false)
  private void setControllers(List<Controller<PkMainFrame>> controllers) {
    this.controllers = controllers;
  }

  @Override
  public String getGuiPropFile() {
    return GUI_PROP_FILE;
  }

}
