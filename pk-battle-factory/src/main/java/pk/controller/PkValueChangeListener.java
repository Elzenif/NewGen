package pk.controller;

import com.vaadin.data.HasValue;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.HasComponents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.main.PkComboBox;
import pk.view.main.PkInfoGrid;
import pk.view.main.PkInfoRow;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Germain on 10/07/2017.
 */
public abstract class PkValueChangeListener<T> implements HasValue.ValueChangeListener<T> ,
    FieldEvents.FocusListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkValueChangeListener.class);
  private final PkInfoGrid pkInfoGrid;
  private final Function<String, Stream<PokemonFactoryDTO>> findFunction;

  private PkComboBox<T> cb;
  private String param;

  protected PkValueChangeListener(PkInfoGrid pkInfoGrid, Function<String, Stream<PokemonFactoryDTO>> findFunction) {
    this.pkInfoGrid = pkInfoGrid;
    this.findFunction = findFunction;
  }

  @Override
  public void valueChange(HasValue.ValueChangeEvent<T> event) {
    updateGrid((PkComboBox<T>) event.getSource());
  }

  @Override
  public void focus(FieldEvents.FocusEvent event) {
    updateGrid((PkComboBox<T>) event.getSource());
  }

  private void updateGrid(PkComboBox<T> source) {
    cb = source;
    Optional<T> selectedItem = cb.getSelectedItem();
    selectedItem.ifPresent(t -> param = cb.getModel().getCaptionGenerator().apply(selectedItem.get()));
    HasComponents parent = cb.getParent();
    if (parent instanceof PkInfoRow) {
      pkInfoGrid.setLastRowEdited((PkInfoRow) parent);
    } else {
      throw new IllegalStateException(String.format("Issue with element %s", parent));
    }
    LOGGER.debug(String.format("%s selected", param));
    pkInfoGrid.update(findFunction, param);
  }

}
