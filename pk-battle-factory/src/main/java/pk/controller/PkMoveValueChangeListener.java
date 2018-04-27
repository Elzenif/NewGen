package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.MoveName;
import pk.view.PkInfoGrid;

/**
 * Created by Germain on 11/07/2017.
 */
@Component
public class PkMoveValueChangeListener extends PkValueChangeListener<MoveName> {

  @Autowired
  public PkMoveValueChangeListener(PokemonFactoryController pokemonFactoryController, PkInfoGrid pkInfoGrid) {
    super(pkInfoGrid, pokemonFactoryController::findByMove);
  }
}
