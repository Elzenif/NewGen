package pk.view.main;

import com.vaadin.data.provider.DataProvider;
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
import pk.model.entity.ItemName;
import pk.model.entity.MoveName;
import pk.model.entity.NatureName;
import pk.model.entity.PokemonSpeciesName;
import pk.view.model.PkItemComboBoxModel;
import pk.view.model.PkMoveComboBoxModel;
import pk.view.model.PkNameComboBoxModel;
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
  private final PkNameComboBoxModel pkNameComboBoxModel;
  private final PkNatureComboBoxModel pkNatureComboBoxModel;
  private final PkItemComboBoxModel pkItemComboBoxModel;
  private final PkMoveComboBoxModel pkMoveComboBoxModel;
  private PkInfoRow lastRowEdited;

  @Autowired
  public PkInfoGrid(PokemonFactoryController pokemonFactoryController,
                    PkNameComboBoxModel pkNameComboBoxModel, PkNatureComboBoxModel pkNatureComboBoxModel,
                    PkItemComboBoxModel pkItemComboBoxModel, PkMoveComboBoxModel pkMoveComboBoxModel) {
    this.pokemonFactoryController = pokemonFactoryController;
    this.pkNameComboBoxModel = pkNameComboBoxModel;
    this.pkNatureComboBoxModel = pkNatureComboBoxModel;
    this.pkItemComboBoxModel = pkItemComboBoxModel;
    this.pkMoveComboBoxModel = pkMoveComboBoxModel;

    setSizeFull();
    setSelectionMode(SelectionMode.SINGLE);
    setupColumns();
    getEditor().setEnabled(true);

    setupSelectionListener();
    setupSaveListener();
  }

  private void setupSelectionListener() {
    addSelectionListener(event -> event.getFirstSelectedItem().ifPresent(p -> {
      if (lastRowEdited != null) {
        lastRowEdited.setPokemonAndShowText(p);
      }
    }));
  }

  private void setupSaveListener() {
    getEditor().addSaveListener(event -> {
      PokemonFactoryDTO pokemonFactoryDTO = event.getBean();
      if (newLine) {
        pokemonFactoryController.insertNewPokemon(pokemonFactoryDTO);
        LOGGER.debug(String.format("New %s was saved", pokemonFactoryDTO.toString()));
        update(pokemonFactoryController::findByName, pokemonFactoryDTO.getPkName());
      } else {
        pokemonFactoryController.update(pokemonFactoryDTO);
        LOGGER.debug(String.format("%s was updated", pokemonFactoryDTO.toString()));
      }
      getDataProvider().refreshAll();
    });
  }

  public void update(Function<String, Stream<PokemonFactoryDTO>> findFunction, String param) {
    newLine = false;
    setDataProvider(DataProvider.fromStream(findFunction.apply(param)));
  }

  public void newLine() {
    newLine = true;
    setDataProvider(DataProvider.ofItems(new PokemonFactoryDTO()));
  }

  private void setupColumns() {
    CollectionSuggestionProvider speciesNameProvider = new CollectionSuggestionProvider(
        pkNameComboBoxModel.getAllElements().stream().map(PokemonSpeciesName::getName).collect(Collectors.toList()),
        MatchMode.BEGINS, true, Locale.getDefault());
    AutocompleteTextField speciesNameTextField = new AutocompleteTextField()
        .withSuggestionProvider(speciesNameProvider);
    addColumn(PokemonFactoryDTO::getPkName, new TextRenderer())
        .setCaption(resourceBundle.getString("name"))
        .setExpandRatio(2)
        .setEditorComponent(speciesNameTextField, PokemonFactoryDTO::setPkName);

    CollectionSuggestionProvider natureNameProvider = new CollectionSuggestionProvider(
        pkNatureComboBoxModel.getAllElements().stream().map(NatureName::getName).collect(Collectors.toList()),
        MatchMode.BEGINS, true, Locale.getDefault());
    AutocompleteTextField natureTextField = new AutocompleteTextField()
        .withSuggestionProvider(natureNameProvider);
    addColumn(PokemonFactoryDTO::getNatureName, new TextRenderer())
        .setCaption(resourceBundle.getString("nature"))
        .setExpandRatio(2)
        .setEditorComponent(natureTextField, PokemonFactoryDTO::setNatureName);

    CollectionSuggestionProvider itemNameProvider = new CollectionSuggestionProvider(
        pkItemComboBoxModel.getAllElements().stream().map(ItemName::getName).collect(Collectors.toList()),
        MatchMode.BEGINS, true, Locale.getDefault());
    AutocompleteTextField itemTextField = new AutocompleteTextField()
        .withSuggestionProvider(itemNameProvider);
    addColumn(PokemonFactoryDTO::getItemName, new TextRenderer())
        .setCaption(resourceBundle.getString("item"))
        .setExpandRatio(2)
        .setEditorComponent(itemTextField, PokemonFactoryDTO::setItemName);

    TextField hpTextField = new TextField();
    addColumn(p -> p.getStats().get(1).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("hp"))
        .setExpandRatio(0)
        .setEditorComponent(hpTextField, (p, ev) -> p.getStats().put(1, Integer.valueOf(ev)));

    TextField atkTextField = new TextField();
    addColumn(p -> p.getStats().get(2).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("atk"))
        .setExpandRatio(0)
        .setEditorComponent(atkTextField, (p, ev) -> p.getStats().put(2, Integer.valueOf(ev)));

    TextField defTextField = new TextField();
    addColumn(p -> p.getStats().get(3).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("def"))
        .setExpandRatio(0)
        .setEditorComponent(defTextField, (p, ev) -> p.getStats().put(3, Integer.valueOf(ev)));

    TextField spAtkTextField = new TextField();
    addColumn(p -> p.getStats().get(4).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("spAtk"))
        .setExpandRatio(0)
        .setEditorComponent(spAtkTextField, (p, ev) -> p.getStats().put(4, Integer.valueOf(ev)));

    TextField spDefTextField = new TextField();
    addColumn(p -> p.getStats().get(5).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("spDef"))
        .setExpandRatio(0)
        .setEditorComponent(spDefTextField, (p, ev) -> p.getStats().put(5, Integer.valueOf(ev)));

    TextField speedTextField = new TextField();
    addColumn(p -> p.getStats().get(6).toString(), new TextRenderer())
        .setCaption(resourceBundle.getString("speed"))
        .setExpandRatio(0)
        .setEditorComponent(speedTextField, (p, ev) -> p.getStats().put(6, Integer.valueOf(ev)));

    CollectionSuggestionProvider moveNameProvider = new CollectionSuggestionProvider(
        pkMoveComboBoxModel.getAllElements().stream().map(MoveName::getName).collect(Collectors.toList()),
        MatchMode.BEGINS, true, Locale.getDefault());

    AutocompleteTextField move1TextField = new AutocompleteTextField()
        .withSuggestionProvider(moveNameProvider);
    addColumn(p -> p.getMoves().get(1), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 1")
        .setExpandRatio(2)
        .setEditorComponent(move1TextField, (p, move) -> p.getMoves().put(1, move));

    AutocompleteTextField move2TextField = new AutocompleteTextField()
        .withSuggestionProvider(moveNameProvider);
    addColumn(p -> p.getMoves().get(2), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 2")
        .setExpandRatio(2)
        .setEditorComponent(move2TextField, (p, move) -> p.getMoves().put(2, move));

    AutocompleteTextField move3TextField = new AutocompleteTextField()
        .withSuggestionProvider(moveNameProvider);
    addColumn(p -> p.getMoves().get(3), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 3")
        .setExpandRatio(2)
        .setEditorComponent(move3TextField, (p, move) -> p.getMoves().put(3, move));

    AutocompleteTextField move4TextField = new AutocompleteTextField()
        .withSuggestionProvider(moveNameProvider);
    addColumn(p -> p.getMoves().get(4), new TextRenderer())
        .setCaption(resourceBundle.getString("move") + " 4")
        .setExpandRatio(2)
        .setEditorComponent(move4TextField, (p, move) -> p.getMoves().put(4, move));

    TextField encounter50TextField = new TextField();
    addColumn(PokemonFactoryDTO::getEncounter50, new TextRenderer())
        .setCaption(resourceBundle.getString("encounter") + " 50")
        .setExpandRatio(0)
        .setEditorComponent(encounter50TextField, PokemonFactoryDTO::setEncounter50);

    TextField encounter100TextField = new TextField();
    addColumn(PokemonFactoryDTO::getEncounter100, new TextRenderer())
        .setCaption(resourceBundle.getString("encounter") + " 100")
        .setExpandRatio(0)
        .setEditorComponent(encounter100TextField, PokemonFactoryDTO::setEncounter100);
  }

  public void setLastRowEdited(PkInfoRow lastRowEdited) {
    this.lastRowEdited = lastRowEdited;
  }
}
