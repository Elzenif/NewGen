package pk.view.model;

import pk.view.PkGenerationAware;
import pk.view.menu.OptionMenu;

import javax.swing.DefaultComboBoxModel;

/**
 * Created by Germain on 12/07/2017.
 */
public abstract class PkComboBoxModel extends DefaultComboBoxModel<Object> implements PkGenerationAware {

  private final OptionMenu optionMenu;
  protected GetAllFunction getAllFunction;

  public PkComboBoxModel(OptionMenu optionMenu) {
    this.optionMenu = optionMenu;
  }

  public void init() {
    addAll(1, optionMenu.getSelectedGeneration());
    optionMenu.addPkGenerationAware(this);
  }

  private void addAll(Integer generationMin, Integer generationMax) {
    for (Object item : getAllFunction.apply(generationMin, generationMax)) {
      addElement(item);
    }
  }

  private void removeAll(Integer generationMin, Integer generationMax) {
    for (Object item : getAllFunction.apply(generationMin, generationMax)) {
      removeElement(item);
    }
  }

  @Override
  public void updateGeneration(int oldGeneration, int newGeneration) {
    if (oldGeneration > newGeneration) {
      removeAll(newGeneration + 1, oldGeneration);
    } else if (oldGeneration < newGeneration) {
      addAll(oldGeneration + 1, newGeneration);
    }
  }
}
