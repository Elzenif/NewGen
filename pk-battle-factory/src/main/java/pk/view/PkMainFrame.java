package pk.view;

import commons.controller.MainFrameWindowListener;
import commons.view.AMainFrame;
import org.jetbrains.annotations.NonNls;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import java.io.File;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
public class PkMainFrame extends AMainFrame {

  @NonNls
  private static final String GUI_PROP_FILE = "gui.properties";

  public PkMainFrame() {
    setUpUIComponents();
    setControllers();

    setTitle(resourceBundle.getString("title"));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    manageOptionFile(new File(GUI_PROP_FILE));

    setResizable(true);
  }

  private void setUpUIComponents() {

  }

  private void setControllers() {
    addWindowListener(new MainFrameWindowListener(this));
  }

  @Override
  public String getGuiPropFile() {
    return GUI_PROP_FILE;
  }

}
