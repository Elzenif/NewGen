package pk.view;

import com.vaadin.data.HasDataProvider;
import com.vaadin.data.provider.DataProvider;
import org.jetbrains.annotations.NotNull;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.main.PkInfoRow;
import pk.view.main.TeamPanel;

import java.util.List;
import java.util.stream.Collectors;

public final class ViewUtils {

  public static void refreshData(@NotNull TeamPanel<? extends PkInfoRow> teamPanel,
                                 @NotNull HasDataProvider<PokemonFactoryDTO> hasDataProvider) {
    List<PokemonFactoryDTO> pokemons = teamPanel.getPkInfoRows().stream()
        .map(PkInfoRow::getPokemonFactoryDTO)
        .collect(Collectors.toList());
    hasDataProvider.setDataProvider(DataProvider.ofCollection(pokemons));
  }

}
