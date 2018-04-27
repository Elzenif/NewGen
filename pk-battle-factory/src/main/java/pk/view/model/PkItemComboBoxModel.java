package pk.view.model;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.ItemName;
import pk.model.repository.ItemNameRepository;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class PkItemComboBoxModel implements PkComboBoxModel<ItemName> {

  private final ItemNameRepository itemNameRepository;

  @Autowired
  public PkItemComboBoxModel(ItemNameRepository itemNameRepository) {
    this.itemNameRepository = itemNameRepository;
  }

  @Override
  public List<ItemName> getAllElements() {
    return itemNameRepository.findAllByLanguageForFactory(Locale.getDefault().getLanguage(), Constants.GENERATION);
  }

  @Override
  public Function<ItemName, String> getCaptionGenerator() {
    return ItemName::getName;
  }

}
