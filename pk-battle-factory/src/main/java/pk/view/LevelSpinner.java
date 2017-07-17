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
public class LevelSpinner extends JSpinner implements ChangeListener {

  private final SpinnerNumberModel model;
  private final PokemonFactoryController pokemonFactoryController;

  public LevelSpinner(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
    model = new SpinnerNumberModel(100, 50, 100, 50);
    setModel(model);

    addChangeListener(this);
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    pokemonFactoryController.setLevel(model.getNumber().intValue());
  }
}
