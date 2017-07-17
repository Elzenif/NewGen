package pk.view;

import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Germain on 17/07/2017.
 */
@Component
public class IVSpinner extends JSpinner implements ChangeListener {

  private final SpinnerNumberModel model;
  private final PokemonFactoryController pokemonFactoryController;

  public IVSpinner(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
    model = new SpinnerNumberModel(0, 0, 31, 1);
    setModel(model);

    addChangeListener(this);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    pokemonFactoryController.setIv(model.getNumber().intValue());
  }
}
