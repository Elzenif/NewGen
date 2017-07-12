package pk.view.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.ItemName;
import pk.model.repository.ItemNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkItemComboBoxModel extends PkComboBoxModel {

  private final ItemNameRepository itemNameRepository;

  @Autowired
  public PkItemComboBoxModel(OptionMenu optionMenu, ItemNameRepository itemNameRepository) {
    super(optionMenu);
    this.itemNameRepository = itemNameRepository;
    getAllFunction = this::getAllNatureNames;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  private Object[] getAllNatureNames(Integer generationMin, Integer generationMax) {
    return itemNameRepository
        .findAllByLanguage(Locale.getDefault().getLanguage())
        .stream()
        .map(ItemName::getName)
        .toArray();
  }
}
