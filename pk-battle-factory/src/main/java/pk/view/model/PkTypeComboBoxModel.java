package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.TypeName;
import pk.model.repository.TypeNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkTypeComboBoxModel extends PkComboBoxModel {

  private final TypeNameRepository typeNameRepository;

  public PkTypeComboBoxModel(OptionMenu optionMenu, TypeNameRepository typeNameRepository) {
    super(optionMenu);
    this.typeNameRepository = typeNameRepository;
    getAllFunction = this::getAllTypeNames;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  private Object[] getAllTypeNames(Integer generationMax) {
    return typeNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage(), generationMax)
        .stream()
        .map(TypeName::getName)
        .toArray();
  }
}
