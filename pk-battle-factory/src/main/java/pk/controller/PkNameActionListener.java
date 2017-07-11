package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.PkInfoTable;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkNameActionListener extends DelayedActionListener {

  @Autowired
  public PkNameActionListener(PokemonFactoryController pokemonFactoryController, PkInfoTable pkInfoTable) {
    super(pkInfoTable, pokemonFactoryController::findByName);
  }
}
