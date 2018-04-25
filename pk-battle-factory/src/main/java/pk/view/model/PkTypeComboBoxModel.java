package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.TypeName;
import pk.model.repository.TypeNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkTypeComboBoxModel extends PkComboBoxModel<TypeName> {

  private final TypeNameRepository typeNameRepository;

  public PkTypeComboBoxModel(OptionMenu optionMenu, TypeNameRepository typeNameRepository) {
    super(optionMenu);
    this.typeNameRepository = typeNameRepository;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  @Override
  public List<TypeName> getAllElements() {
    return typeNameRepository.findAllByLanguage(Locale.getDefault().getLanguage(), getGeneration());
  }

  @Override
  public Function<TypeName, String> getCaptionGenerator() {
    return TypeName::getName;
  }

}
