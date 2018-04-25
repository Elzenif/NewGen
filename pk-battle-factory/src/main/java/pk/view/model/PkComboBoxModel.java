package pk.view.model;

import pk.view.PkGenerationAware;
import pk.view.menu.OptionMenu;

import java.util.List;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
public abstract class PkComboBoxModel<T> implements PkGenerationAware {

  private final OptionMenu optionMenu;

  public PkComboBoxModel(OptionMenu optionMenu) {
    this.optionMenu = optionMenu;
  }

  public void init() {
    optionMenu.addPkGenerationAware(this);
  }

  @Override
  public void updateGeneration() {
  }

  public abstract List<T> getAllElements();

  public abstract Function<T, String> getCaptionGenerator();

  protected Integer getGeneration() {
    return optionMenu.getSelectedGeneration();
  }
}
