package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.PkInfoTable;

/**
 * Created by Germain on 11/07/2017.
 */
@Component
public class PkMoveActionListener extends DelayedActionListener {

  @Autowired
  public PkMoveActionListener(PokemonFactoryController pokemonFactoryController, PkInfoTable pkInfoTable) {
    super(pkInfoTable, pokemonFactoryController::findByMove);
  }
}
