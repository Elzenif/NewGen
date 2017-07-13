package pk.view.model;

import pk.view.PkGenerationAware;
import pk.view.menu.OptionMenu;

import javax.swing.DefaultComboBoxModel;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
public abstract class PkComboBoxModel extends DefaultComboBoxModel<Object> implements PkGenerationAware {

  private final OptionMenu optionMenu;
  protected Function<Integer, Object[]> getAllFunction;

  public PkComboBoxModel(OptionMenu optionMenu) {
    this.optionMenu = optionMenu;
  }

  public void init() {
    addAll(optionMenu.getSelectedGeneration());
    optionMenu.addPkGenerationAware(this);
  }

  private void addAll(Integer generationMax) {
    for (Object item : getAllFunction.apply(generationMax)) {
      addElement(item);
    }
  }

  @Override
  public void updateGeneration() {
    removeAllElements();
    addAll(optionMenu.getSelectedGeneration());
  }
}
