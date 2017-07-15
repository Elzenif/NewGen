package pk.view;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import pk.view.model.PkComboBoxModel;
import pk.view.model.SharedComboBoxModel;

import javax.swing.JComboBox;

/**
 * Created by Germain on 12/07/2017.
 */
public class PkComboBox extends JComboBox<Object> {

  public PkComboBox(PkComboBoxModel originalComboBoxModel) {
    setModel(new SharedComboBoxModel(originalComboBoxModel));
    AutoCompleteDecorator.decorate(this);
  }
}
