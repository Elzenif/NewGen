package pk.view.model;

import commons.Constants;
import org.springframework.stereotype.Component;
import pk.model.entity.TypeName;
import pk.model.repository.TypeNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkTypeComboBoxModel implements PkComboBoxModel<TypeName> {

  private final TypeNameRepository typeNameRepository;

  public PkTypeComboBoxModel(TypeNameRepository typeNameRepository) {
    this.typeNameRepository = typeNameRepository;
  }

  @Override
  public List<TypeName> getAllElements() {
    return typeNameRepository.findAllByLanguage(Locale.getDefault().getLanguage(), Constants.GENERATION);
  }

  @Override
  public Function<TypeName, String> getCaptionGenerator() {
    return TypeName::getName;
  }

}
