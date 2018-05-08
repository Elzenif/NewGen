package pk.view.helper;

import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;
import pk.model.dto.PokemonFactoryDTO;

public abstract class ResultPanel extends VerticalLayout {

  public abstract ResultPanel refresh(CheckBoxGroup<PokemonFactoryDTO> checkBoxGroup, GridLayout gridLayout);
}
