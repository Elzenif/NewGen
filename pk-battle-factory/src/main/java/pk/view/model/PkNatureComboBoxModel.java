package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.NatureName;
import pk.model.repository.NatureNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkNatureComboBoxModel implements PkComboBoxModel<NatureName> {

  private final NatureNameRepository natureNameRepository;

  public PkNatureComboBoxModel(NatureNameRepository natureNameRepository) {
    this.natureNameRepository = natureNameRepository;
  }

  @Override
  public List<NatureName> getAllElements() {
    return natureNameRepository.findAllByLanguage(Locale.getDefault().getLanguage());
  }

  @Override
  public Function<NatureName, String> getCaptionGenerator() {
    return NatureName::getName;
  }

}
