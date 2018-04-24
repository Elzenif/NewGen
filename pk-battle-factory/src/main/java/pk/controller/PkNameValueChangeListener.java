package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.PokemonSpeciesName;
import pk.view.PkInfoGrid;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkNameValueChangeListener extends PkValueChangeListener<PokemonSpeciesName> {

  @Autowired
  public PkNameValueChangeListener(PokemonFactoryController pokemonFactoryController, PkInfoGrid pkInfoGrid) {
    super(pkInfoGrid, pokemonFactoryController::findByName);
  }
}
