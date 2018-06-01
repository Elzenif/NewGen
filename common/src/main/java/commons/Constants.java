package commons;

import org.jetbrains.annotations.NonNls;

import java.awt.Font;
import java.util.ResourceBundle;

/**
 * Created by Germain on 08/05/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public class Constants {

  public static final int JFRAME_HEIGHT = 800;
  public static final int JFRAME_WIDTH = 1200;

  public static final int JPANEL_HGAP = 12;
  public static final int JPANEL_VGAP = 12;

  public static final int FONT_SIZE_INT = 12;
  public static final float FONT_SIZE_FLOAT = 12f;

  public static final int GENERATION = 4;

  @NonNls
  public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("locale/user-interface");
  @NonNls
  public static final ResourceBundle enResourceBundle = ResourceBundle.getBundle("locale/user-interface_en");

  @NonNls
  public static final String SOURCE_CODE_PRO = "Source Code Pro";

  public static Font BENGUIAB_FONT;
  public static Font DAUPHINN_FONT;
  public static Font LITHOGRL_FONT;
  public static Font LITHOGRB_FONT;
  public static Font PKMON_FONT;
}
