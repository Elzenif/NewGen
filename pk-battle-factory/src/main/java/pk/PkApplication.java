package pk;

import commons.Constants;
import commons.MainHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pk.view.PkMainFrame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 * Created by Germain on 01/07/2017.
 */
@SpringBootApplication
public class PkApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(PkApplication.class).headless(false)
        .run(args);
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
      LOGGER.error("Error while setting look and feel", e);
    }
    try {
      Constants.PKMON_FONT = MainHelper.initFont("PKMNDB", 0f);
    } catch (IOException | FontFormatException e) {
      LOGGER.error("Error while initializing font", e);
    }
    MainHelper.setUIFont(new FontUIResource(Constants.PKMON_FONT));

    EventQueue.invokeLater(() -> {
      PkMainFrame mainFrame = context.getBean(PkMainFrame.class);
      mainFrame.setVisible(true);
    });
  }

}
