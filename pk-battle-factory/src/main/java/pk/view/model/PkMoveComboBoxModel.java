package pk.view.model;

import org.springframework.stereotype.Component;
import pk.model.entity.MoveName;
import pk.model.repository.MoveNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkMoveComboBoxModel extends PkComboBoxModel {

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

  private Object[] getAllMoveNames(Integer generationMin, Integer generationMax) {
    return moveNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage(), generationMin, generationMax)
        .stream()
        .map(MoveName::getName)
        .toArray();
  }
}
