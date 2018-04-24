package pk.controller;

import com.vaadin.data.HasValue;
import com.vaadin.ui.HasComponents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.PkComboBox;
import pk.view.PkInfoGrid;
import pk.view.PkInfoRow;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Germain on 10/07/2017.
 */
public abstract class PkValueChangeListener<T> implements HasValue.ValueChangeListener<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkValueChangeListener.class);
  private final PkInfoGrid pkInfoGrid;
  private final Function<String, Stream<PokemonFactoryDTO>> findFunction;

  private PkComboBox<T> cb;
  private String param;

  public PkValueChangeListener(PkInfoGrid pkInfoGrid, Function<String, Stream<PokemonFactoryDTO>> findFunction) {
    this.pkInfoGrid = pkInfoGrid;
    this.findFunction = findFunction;
  }

  @Override
  public void valueChange(HasValue.ValueChangeEvent<T> event) {
    cb = (PkComboBox<T>) event.getSource();
    Optional<T> selectedItem = cb.getSelectedItem();
    selectedItem.ifPresent(t -> param = cb.getModel().getCaptionGenerator().apply(selectedItem.get()));
    HasComponents parent = cb.getParent();
    if (parent instanceof PkInfoRow) {
      pkInfoGrid.setLastRowEdited((PkInfoRow) parent);
    } else if (parent.getParent() instanceof PkInfoRow) {
      pkInfoGrid.setLastRowEdited((PkInfoRow) parent.getParent());
    } else {
      throw new IllegalStateException(String.format("Issue with element %s", parent));
    }
    LOGGER.debug(String.format("%s selected", param));
    pkInfoGrid.update(findFunction, param);
  }

}
