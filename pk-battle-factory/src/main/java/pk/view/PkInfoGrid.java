package pk.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.renderers.TextRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkInfoGrid extends Grid<PokemonFactoryDTO> {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoGrid.class);
  private boolean newLine;
  private List<PokemonFactoryDTO> pokemonFactoryDTOS;
  private PkInfoRow lastRowEdited;
  private final PokemonFactoryController pokemonFactoryController;


  @Autowired
  public PkInfoGrid(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;

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

    TextField natureTextField = new TextField();
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
    this.lastRowEdited = lastRowEdited;
  }
}
