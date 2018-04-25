package pk.view.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.ItemName;
import pk.model.repository.ItemNameRepository;
import pk.view.menu.OptionMenu;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkItemComboBoxModel extends PkComboBoxModel<ItemName> {

  private final ItemNameRepository itemNameRepository;

  @Autowired
  public PkItemComboBoxModel(OptionMenu optionMenu, ItemNameRepository itemNameRepository) {
    super(optionMenu);
    this.itemNameRepository = itemNameRepository;
  }

  @PostConstruct
  public void init() {
    super.init();
  }

  @Override
  public List<ItemName> getAllElements() {
    return itemNameRepository.findAllByLanguageForFactory(Locale.getDefault().getLanguage(), getGeneration());
  }

  @Override
  public Function<ItemName, String> getCaptionGenerator() {
    return ItemName::getName;
  }

}
