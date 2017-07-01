package pk.controller;

import pk.view.PkInfoRow;

import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 01/07/2017.
 */
public class PkDocumentListener implements DocumentListener {

  private final PkInfoRow pkInfoRow;
  private final ActionListener timerListener = new TimerListener();
  private final Timer writeDeleteTimer = new Timer(1000, timerListener);

  public PkDocumentListener(PkInfoRow pkInfoRow) {
    this.pkInfoRow = pkInfoRow;
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    pkInfoRow.getLabel().setText("EDITING");
    writeDeleteTimer.restart();
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    pkInfoRow.getLabel().setText("DELETING");
    writeDeleteTimer.restart();
  }

  @Override
  public void changedUpdate(DocumentEvent e) {

  }

  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      pkInfoRow.getLabel().setText("STOP EDITING");
      Timer timer = (Timer) e.getSource();
      timer.stop();
    }
  }
}
