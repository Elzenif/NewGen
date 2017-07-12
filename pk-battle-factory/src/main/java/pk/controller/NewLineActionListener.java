package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.view.PkInfoTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 12/07/2017.
 */
@Component
public class NewLineActionListener implements ActionListener {

  private final PokemonFactoryController pokemonFactoryController;
  private final PkInfoTable pkInfoTable;

  @Autowired
  public NewLineActionListener(PokemonFactoryController pokemonFactoryController, PkInfoTable pkInfoTable) {
    this.pokemonFactoryController = pokemonFactoryController;
    this.pkInfoTable = pkInfoTable;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }
}
