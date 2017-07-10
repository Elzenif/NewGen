package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.PkInfoTable;

import javax.swing.JComboBox;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkNameActionListener implements DelayedActionListener {

  private final PokemonFactoryController pokemonFactoryController;
  private final PkInfoTable pkInfoTable;
  private final ActionListener timerListener = new TimerListener();
  private final Timer timer = new Timer(getDelay(), timerListener);

  private String name;

  @Autowired
  public PkNameActionListener(PokemonFactoryController pokemonFactoryController, PkInfoTable pkInfoTable) {
    this.pokemonFactoryController = pokemonFactoryController;
    this.pkInfoTable = pkInfoTable;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timer.restart();
    JComboBox cb = (JComboBox) e.getSource();
    name = (String) cb.getSelectedItem();
  }

  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      pkInfoTable.update(pokemonFactoryController.findByName(name));
      Timer timer = (Timer) e.getSource();
      timer.stop();
    }
  }
}
