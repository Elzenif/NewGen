package pk.view;

import com.vaadin.ui.ComboBox;
import pk.view.model.PkComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
public class PkComboBox<T> extends ComboBox<T> {

  private final PkComboBoxModel<T> model;

  public PkComboBox(PkComboBoxModel<T> model, String caption) {
    super(caption, model.getAllElements());
    this.model = model;
    setItemCaptionGenerator(model.getCaptionGenerator()::apply);
    setEmptySelectionAllowed(false);
    setWidth(100.0F, Unit.PERCENTAGE);
  }

  public PkComboBoxModel<T> getModel() {
    return model;
  }
}
