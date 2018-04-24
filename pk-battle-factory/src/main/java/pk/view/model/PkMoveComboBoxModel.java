package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.MoveName;
import pk.model.repository.MoveNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkMoveComboBoxModel extends PkComboBoxModel<MoveName> {

  private final MoveNameRepository moveNameRepository;

  public PkMoveComboBoxModel(OptionMenu optionMenu, MoveNameRepository moveNameRepository) {
    super(optionMenu);
    this.moveNameRepository = moveNameRepository;
    getAllFunction = this::getAllMoveNames;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  @Override
  public List<MoveName> getAllElements() {
    return moveNameRepository.findAllByLanguage(Locale.getDefault().getLanguage(), getGeneration());
  }

  @Override
  public Function<MoveName, String> getCaptionGenerator() {
    return MoveName::getName;
  }

  private Object[] getAllMoveNames(Integer generationMax) {
    return moveNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage(), generationMax)
        .stream()
        .map(MoveName::getName)
        .toArray();
  }
}
