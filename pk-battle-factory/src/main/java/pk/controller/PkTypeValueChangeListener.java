package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.entity.TypeName;
import pk.view.main.PkInfoGrid;

/**
 * Created by Germain on 10/07/2017.
 */
@Component
public class PkTypeValueChangeListener extends PkValueChangeListener<TypeName> {

  @Autowired
  public PkTypeValueChangeListener(PokemonFactoryController pokemonFactoryController, PkInfoGrid pkInfoGrid) {
    super(pkInfoGrid, pokemonFactoryController::findByType);
  }
}
