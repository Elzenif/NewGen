package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.NatureName;
import pk.model.repository.NatureNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkNatureComboBoxModel extends PkComboBoxModel<NatureName> {

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

  @Override
  public List<NatureName> getAllElements() {
    return natureNameRepository.findAllByLanguage(Locale.getDefault().getLanguage());
  }

  @Override
  public Function<NatureName, String> getCaptionGenerator() {
    return NatureName::getName;
  }

  private Object[] getAllNatureNames(Integer generationMax) {
    return natureNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage())
        .stream()
        .map(NatureName::getName)
        .toArray();
  }
}
