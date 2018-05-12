package pk.view.utils;

import com.vaadin.ui.CheckBoxGroup;
import commons.Constants;
import pk.model.dto.PokemonFactoryDTO;

public class PkCheckBoxGroup extends CheckBoxGroup<PokemonFactoryDTO> {

  public PkCheckBoxGroup(String captionKey) {
    super(Constants.resourceBundle.getString(captionKey));
    setItemCaptionGenerator(PokemonFactoryDTO::getPkName);
    setItemEnabledProvider(p -> p.getPkName() != null);
  }
}
