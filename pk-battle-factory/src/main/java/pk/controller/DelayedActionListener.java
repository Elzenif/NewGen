package pk.controller;

import pk.model.dto.PokemonFactoryDTO;
import pk.view.PkInfoRow;
import pk.view.PkInfoTable;

import javax.swing.JComboBox;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Germain on 10/07/2017.
 */
public abstract class DelayedActionListener implements ActionListener {

  private final PkInfoTable pkInfoTable;
  private final ActionListener timerListener = new TimerListener();
  private final Timer timer = new Timer(1500, timerListener);
  private final Function<String, List<PokemonFactoryDTO>> findFunction;

  private JComboBox cb;
  private String name;

  public DelayedActionListener(PkInfoTable pkInfoTable, Function<String, List<PokemonFactoryDTO>> findFunction) {
    this.pkInfoTable = pkInfoTable;
    this.findFunction = findFunction;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timer.restart();
    cb = (JComboBox) e.getSource();
    name = (String) cb.getSelectedItem();
  }

  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      Container parent = cb.getParent();
      if (parent instanceof PkInfoRow) {
        pkInfoTable.setLastRowEdited((PkInfoRow) parent);
      } else {
        pkInfoTable.setLastRowEdited((PkInfoRow) parent.getParent());
      }
      pkInfoTable.update(findFunction.apply(name));
      Timer timer = (Timer) e.getSource();
      timer.stop();
    }
  }

}
