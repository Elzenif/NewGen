package commons.utils;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * Created by Germain on 18/06/2016.
 */
public class TextFieldUtils {

  public static JFormattedTextField createTwoDigitsField() {
    MaskFormatter maskFormatter = null;
    try {
      maskFormatter = new MaskFormatter("##");
    } catch (ParseException e) {
      e.printStackTrace();
    }
    JFormattedTextField textField = new JFormattedTextField(maskFormatter);
    textField.setColumns(2);
    textField.setValue(null);
    return textField;
  }
}
