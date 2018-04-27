package pk.view.model;

import commons.Constants;
import org.springframework.stereotype.Component;
import pk.model.entity.MoveName;
import pk.model.repository.MoveNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkMoveComboBoxModel implements PkComboBoxModel<MoveName> {

  private final MoveNameRepository moveNameRepository;

  public PkMoveComboBoxModel(MoveNameRepository moveNameRepository) {
    this.moveNameRepository = moveNameRepository;
  }

  @Override
  public List<MoveName> getAllElements() {
    return moveNameRepository.findAllByLanguage(Locale.getDefault().getLanguage(), Constants.GENERATION);
  }

  @Override
  public Function<MoveName, String> getCaptionGenerator() {
    return MoveName::getName;
  }

}
