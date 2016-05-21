package mvc.controller.dice;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 07/05/2016.
 */
public class RollDiceButtonController implements ActionListener {

  private JLabel resultDice;

  public RollDiceButtonController(JLabel resultDice) {
    this.resultDice = resultDice;
  }

  public void actionPerformed(ActionEvent e) {
    int result = (int) (Math.random() * 6 + 1);
    resultDice.setText(String.valueOf(result));
  }
}
