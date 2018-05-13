package pk.view.main;

import com.vaadin.ui.ComboBox;
import pk.view.model.PkComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
public class PkComboBox<T> extends ComboBox<T> {

  private final PkComboBoxModel<T> model;

  protected PkComboBox(PkComboBoxModel<T> model, String caption) {
    super(caption, model.getAllElements());
    this.model = model;
    setItemCaptionGenerator(model.getCaptionGenerator()::apply);
    setEmptySelectionAllowed(true);
    setWidth(11, Unit.EM);
  }

  public PkComboBoxModel<T> getModel() {
    return model;
  }
}
