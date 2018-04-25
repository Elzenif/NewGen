package pk.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.renderers.TextRenderer;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import eu.maxschuster.vaadin.autocompletetextfield.provider.CollectionSuggestionProvider;
import eu.maxschuster.vaadin.autocompletetextfield.provider.MatchMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.NatureName;
import pk.view.model.PkNatureComboBoxModel;

import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkInfoGrid extends Grid<PokemonFactoryDTO> {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoGrid.class);
  private boolean newLine;
  private final PokemonFactoryController pokemonFactoryController;
  private final PkNatureComboBoxModel pkNatureComboBoxModel;


  @Autowired
  public PkInfoGrid(PokemonFactoryController pokemonFactoryController,
                    PkNatureComboBoxModel pkNatureComboBoxModel) {
    this.pokemonFactoryController = pokemonFactoryController;
    this.pkNatureComboBoxModel = pkNatureComboBoxModel;

    setSizeFull();
    setSelectionMode(SelectionMode.NONE);
    setupColumns();
    getEditor().setEnabled(true);

    setupSaveListener();
  }

  private void setupSaveListener() {
    getEditor().addSaveListener(event -> {
      PokemonFactoryDTO pokemonFactoryDTO = event.getBean();
      if (newLine) {
        pokemonFactoryController.insertNewPokemon(pokemonFactoryDTO);
        LOGGER.debug(String.format("New %s was saved", pokemonFactoryDTO.toString()));
      } else {
        pokemonFactoryController.update(pokemonFactoryDTO);
        LOGGER.debug(String.format("%s was updated", pokemonFactoryDTO.toString()));
      }
      getDataProvider().refreshAll();
    });
  }

  public void update(Function<String, Stream<PokemonFactoryDTO>> findFunction, String param) {
    newLine = false;

    setDataProvider(
        (sortOrder, offset, limit) -> findFunction.apply(param),
        () -> Math.toIntExact(findFunction.apply(param).count()));
  }

  public void newLine() {
    newLine = true;
//    pokemonFactoryDTOS = Collections.emptyList();
  }

  private void setupColumns() {
    TextField nameTextField = new TextField();
    addColumn(PokemonFactoryDTO::getPkName, new TextRenderer())
        .setCaption(resourceBundle.getString("name"))
        .setEditorComponent(nameTextField, PokemonFactoryDTO::setPkName);

    CollectionSuggestionProvider natureNameProvider = new CollectionSuggestionProvider(
        pkNatureComboBoxModel.getAllElements().stream().map(NatureName::getName).collect(Collectors.toList()),
        MatchMode.CONTAINS, true, Locale.getDefault());
    AutocompleteTextField natureTextField = new AutocompleteTextField()
        .withSuggestionProvider(natureNameProvider);
    addColumn(PokemonFactoryDTO::getNatureName, new TextRenderer())
        .setCaption(resourceBundle.getString("nature"))
        .setExpandRatio(2)
        .setEditorComponent(natureTextField, PokemonFactoryDTO::setNatureName);

    TextField itemTextField = new TextField();
    addColumn(PokemonFactoryDTO::getItemName, new TextRenderer())
        .setCaption(resourceBundle.getString("item"))
        .setExpandRatio(2)
        .setEditorComponent(itemTextField, PokemonFactoryDTO::setItemName);

    addColumn(p -> p.getStats().get(0), new TextRenderer())
        .setCaption(resourceBundle.getString("hp"))
        .setExpandRatio(0);

    addColumn(p -> p.getStats().get(1), new TextRenderer())
        .setCaption(resourceBundle.getString("atk"))
        .setExpandRatio(0);

    addColumn(p -> p.getStats().get(2), new TextRenderer())
        .setCaption(resourceBundle.getString("def"))
        .setExpandRatio(0);

    addColumn(p -> p.getStats().get(3), new TextRenderer())
        .setCaption(resourceBundle.getString("spAtk"))
        .setExpandRatio(0);

    addColumn(p -> p.getStats().get(4), new TextRenderer())
        .setCaption(resourceBundle.getString("spDef"))
        .setExpandRatio(0);

    addColumn(p -> p.getStats().get(5), new TextRenderer())
        .setCaption(resourceBundle.getString("speed"))
        .setExpandRatio(0);

    addColumn(p -> p.getMoves().get(0), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 1")
        .setExpandRatio(2);

    addColumn(p -> p.getMoves().get(1), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 2")
        .setExpandRatio(2);

    addColumn(p -> p.getMoves().get(2), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 3")
        .setExpandRatio(2);

    addColumn(p -> p.getMoves().get(3), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 4")
        .setExpandRatio(2);

    addColumn(PokemonFactoryDTO::getEncounter50, new TextRenderer())
        .setCaption(resourceBundle.getString("encounter") + " 50")
        .setExpandRatio(0);

    addColumn(PokemonFactoryDTO::getEncounter100, new TextRenderer())
        .setCaption(resourceBundle.getString("encounter") + " 100")
        .setExpandRatio(0);

  }


  //  @Override
//  public void tableChanged(TableModelEvent e) {
//    super.tableChanged(e);
//    if (!editing) {
//      if (saveButton != null) {
//        saveButton.setEnabled(true);
//      }
//      editing = true;
//    }
//    if (!newLine) {
//      int selectedRow = getSelectedRow();
//      if (lastRowEdited != null && selectedRow >= 0) {
//        // TODO get value from table + id
//        PokemonFactoryDTO pokemonFactoryDTO = getPokemonFactoryDTO(selectedRow, getColumnCount());
//        pokemonFactoryDTO.setId(pokemonFactoryDTOS.get(selectedRow).getId());
//        lastRowEdited.showText(pokemonFactoryDTO);
//      }
//    }
//  }

  public void setLastRowEdited(PkInfoRow lastRowEdited) {
  }
}
