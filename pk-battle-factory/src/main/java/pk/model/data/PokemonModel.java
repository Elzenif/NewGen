package pk.model.data;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.HashBiMap;
import org.jetbrains.annotations.NotNull;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.main.PkInfoRow;

import java.util.Map;

public abstract class PokemonModel extends ForwardingMap<PkInfoRow, PokemonFactoryDTO> {

  private final HashBiMap<PkInfoRow, PokemonFactoryDTO> delegate;

  protected PokemonModel(int expectedSize) {
    delegate = HashBiMap.create(expectedSize);
  }

  @Override
  protected Map<PkInfoRow, PokemonFactoryDTO> delegate() {
    return delegate;
  }

  /**
   * Check if the given row has a pokemon
   * @param pkInfoRow {@link PkInfoRow}
   * @return true if there is a pokemon
   */
  public boolean hasOnePokemon(PkInfoRow pkInfoRow) {
    return containsKey(pkInfoRow) && get(pkInfoRow).getId() != null;
  }

  public void replacePokemon(PokemonFactoryDTO oldPokemon, PokemonFactoryDTO newPokemon) {
    PkInfoRow pkInfoRow = delegate.inverse().get(oldPokemon);
    put(pkInfoRow, newPokemon);
  }

  @Override
  public PokemonFactoryDTO put(@NotNull PkInfoRow key, @NotNull PokemonFactoryDTO value) {
    PokemonFactoryDTO result = super.put(key, value);
    key.refresh();
    return result;
  }
}
