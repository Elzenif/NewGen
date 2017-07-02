package pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.projection.PokemonFactoryProjection;
import pk.model.repository.PokemonFactoryRepository;
import pk.view.PkInfoTable;

import javax.swing.JComboBox;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkNameActionListener implements ActionListener {

  private final PokemonFactoryRepository pokemonFactoryRepository;
  private final PkInfoTable pkInfoTable;
  private final ActionListener timerListener = new TimerListener();
  private final Timer timer = new Timer(1000, timerListener);

  private String name;

  @Autowired
  public PkNameActionListener(PokemonFactoryRepository pokemonFactoryRepository, PkInfoTable pkInfoTable) {
    this.pokemonFactoryRepository = pokemonFactoryRepository;
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

      List<PokemonFactoryProjection> projections = pokemonFactoryRepository.find(name, Locale.getDefault().getLanguage());

      Vector<Vector<Object>> data = new Vector<>();
      for (PokemonFactoryProjection projection : projections) {
        Vector<Object> vector = new Vector<>();
        vector.add(projection.getPkName());
        vector.add(projection.getNatureName());
        data.add(vector);
      }
      pkInfoTable.getDataModel().setDataVector(data, pkInfoTable.getColumnNames());
      Timer timer = (Timer) e.getSource();
      timer.stop();
    }
  }
}
