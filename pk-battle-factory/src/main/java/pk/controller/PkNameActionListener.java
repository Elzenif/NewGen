package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;
import pk.view.PkInfoTable;

import javax.swing.JComboBox;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkNameActionListener implements ActionListener {

  private final PokemonFactoryController pokemonFactoryController;
  private final PkInfoTable pkInfoTable;
  private final ActionListener timerListener = new TimerListener();
  private final Timer timer = new Timer(1000, timerListener);

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

      List<PokemonFactoryDTO> pokemonFactoryDTOS = pokemonFactoryController.findByName(name);

      Vector<Vector<Object>> data = new Vector<>();
      for (PokemonFactoryDTO pokemonFactoryDTO : pokemonFactoryDTOS) {
        Vector<Object> vector = new Vector<>();
        vector.add(pokemonFactoryDTO.getPkName());
        vector.add(pokemonFactoryDTO.getNatureName());
        vector.add(pokemonFactoryDTO.getItemName());
        vector.addAll(pokemonFactoryDTO.getStats());
        vector.addAll(pokemonFactoryDTO.getMoves());
        data.add(vector);
      }
      pkInfoTable.getDataModel().setDataVector(data, pkInfoTable.getColumnNames());
      Timer timer = (Timer) e.getSource();
      timer.stop();
    }
  }
}
