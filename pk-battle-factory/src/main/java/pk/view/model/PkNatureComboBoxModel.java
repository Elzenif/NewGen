package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.NatureName;
import pk.model.repository.NatureNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkNatureComboBoxModel extends PkComboBoxModel {

  private final NatureNameRepository natureNameRepository;

  public PkNatureComboBoxModel(OptionMenu optionMenu, NatureNameRepository natureNameRepository) {
    super(optionMenu);
    this.natureNameRepository = natureNameRepository;
    getAllFunction = this::getAllNatureNames;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  private Object[] getAllNatureNames(Integer generationMin, Integer generationMax) {
    return natureNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage())
        .stream()
        .map(NatureName::getName)
        .toArray();
  }
}
