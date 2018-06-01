package pk.view.main;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pk.controller.PokemonFactoryController;
import pk.model.data.PokemonRowModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Type;
import pk.view.utils.PkImage;
import pk.view.utils.PkImageType;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends HorizontalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(PkInfoRow.class);
  private final PokemonFactoryController pokemonFactoryController;
  private final PokemonRowModel pokemonRowModel;
  private CssLayout imageLayout;
  private TextArea textArea;
  private TextArea statsArea;
  private ExportButton exportButton;

  public PkInfoRow(PokemonFactoryController pokemonFactoryController, PokemonRowModel pokemonRowModel) {
    setId(UUID.randomUUID().toString());
    this.pokemonFactoryController = pokemonFactoryController;
    this.pokemonRowModel = pokemonRowModel;
  }

  protected void postInit() {
    imageLayout = new CssLayout();
    imageLayout.setVisible(false);
    addComponent(imageLayout);

    textArea = new TextArea();
    textArea.setRows(7);
    textArea.setReadOnly(true);
    textArea.setWidth(20, Unit.EM);
    textArea.setVisible(false);
    addComponent(textArea);

    statsArea = new TextArea();
    statsArea.setRows(6);
    statsArea.setReadOnly(true);
    statsArea.setWidth(8, Unit.EM);
    statsArea.setVisible(false);
    addComponent(statsArea);

    exportButton.setVisible(false);
    addComponent(exportButton);
  }

  public void updatePokemon(PokemonFactoryDTO pokemonFactoryDTO) {
    pokemonRowModel.put(this, pokemonFactoryDTO);
  }

  public void removePokemon() {
    pokemonRowModel.removeKey(this);
  }

  public void refresh() {
    if (pokemonRowModel.hasOnePokemon(this)) {
      PokemonFactoryDTO pokemonFactoryDTO = pokemonRowModel.get(this);
      LOGGER.debug(String.format("Refreshing %s", pokemonFactoryDTO));

      refreshImage(pokemonFactoryDTO);
      refreshText(pokemonFactoryDTO);
      refreshStats(pokemonFactoryDTO);
    } else {
      imageLayout.setVisible(false);
      textArea.setVisible(false);
      statsArea.setVisible(false);
      exportButton.setVisible(false);
    }
  }

  public void refreshStats() {
    if (pokemonRowModel.hasOnePokemon(this)) {
      PokemonFactoryDTO pokemonFactoryDTO = pokemonRowModel.get(this);
      LOGGER.debug(String.format("Refreshing stats of %s", pokemonFactoryDTO));

      refreshStats(pokemonFactoryDTO);
    }
  }

  private void refreshStats(@NotNull PokemonFactoryDTO pokemonFactoryDTO) {
    Map<Integer, Integer> stats = pokemonFactoryController.computeStats(pokemonFactoryDTO);

    statsArea.setValue(printStats(stats));
    statsArea.setVisible(true);
  }

  private String printStats(@NotNull Map<Integer, Integer> stats) {
    return stats.entrySet().stream()
        .map(entry -> printStat(entry.getKey(), entry.getValue()))
        .collect(Collectors.joining("\n"));
  }

  private String printStat(Integer index, int computedStat) {
    String s = PokemonFactoryController.STAT_NAMES.get(index);
    s += " \t" + computedStat;
    return s.length() <= 8 ? '\t' + s : s;
  }

  private void refreshText(@NotNull PokemonFactoryDTO pokemonFactoryDTO) {
    textArea.setValue(pokemonFactoryController.prettyPrint(pokemonFactoryDTO));
    textArea.setVisible(true);
    exportButton.setVisible(true);
  }

  private void refreshImage(@NotNull PokemonFactoryDTO pokemonFactoryDTO) {
    CssLayout newImageLayout = new CssLayout();
    newImageLayout.setWidth("32px");

    PkImage pkImage = PkImage.of(pokemonFactoryDTO);
    newImageLayout.addComponent(pkImage);


    for (Type type : pokemonFactoryDTO.getTypes()) {
      newImageLayout.addComponent(PkImageType.of(type));
    }

    replaceComponent(imageLayout, newImageLayout);
    imageLayout = newImageLayout;
  }

  @Autowired
  public void setExportButton(ExportButton exportButton) {
    this.exportButton = exportButton;
    this.exportButton.setPkInfoRow(this);
    this.exportButton.setPokemonRowModel(pokemonRowModel);
  }
}
