package pk.view;

import pk.view.model.PkComboBoxModel;
import pk.view.model.SharedComboBoxModel;

import javax.swing.JComboBox;

/**
 * Created by Germain on 12/07/2017.
 */
public class PkComboBox extends JComboBox<Object> {

  private final PkComboBoxModel originalComboBoxModel;

  public PkComboBox(PkComboBoxModel originalComboBoxModel) {
    this.originalComboBoxModel = originalComboBoxModel;
    setModel(new SharedComboBoxModel(originalComboBoxModel));
  }

  public PkComboBoxModel getOriginalComboBoxModel() {
    return originalComboBoxModel;
  }
}
