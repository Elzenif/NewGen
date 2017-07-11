package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.PkInfoTable;

/**
 * Created by Germain on 10/07/2017.
 */
@Component
public class PkTypeActionListener extends DelayedActionListener {

  @Autowired
  public PkTypeActionListener(PokemonFactoryController pokemonFactoryController, PkInfoTable pkInfoTable) {
    super(pkInfoTable, pokemonFactoryController::findByType);
  }
}
