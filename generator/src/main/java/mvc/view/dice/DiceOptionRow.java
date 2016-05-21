package mvc.view.dice;

import mvc.controller.dice.RollDiceButtonController;
import mvc.view.Constants;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceOptionRow extends JPanel {

  // TODO add a controller that changes the text of the rollDiceButton according to options selected

  private int diceNumber;

  private JLabel infoLabel;
  private JSpinner numberOfDiceSpinner;
  private SpinnerNumberModel numberOfDiceModel;
  private JButton rollDiceButton;

  DiceOptionRow(int diceNumber) {
    this.diceNumber = diceNumber;
    setComponents();
  }

  private void setComponents() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    infoLabel = new JLabel("D" + diceNumber);
    add(infoLabel);

    numberOfDiceModel = new SpinnerNumberModel(1, 0, 20, 1);
    numberOfDiceSpinner = new JSpinner(numberOfDiceModel);
    add(numberOfDiceSpinner);

    rollDiceButton = new JButton("Roll " + numberOfDiceModel.getNumber() + "D" + diceNumber);
    add(rollDiceButton);
  }

  public int getNumberOfDiceSelected() {
    return numberOfDiceModel.getNumber().intValue();
  }

  void setController(RollDiceButtonController rollDiceButtonController) {
    rollDiceButton.addActionListener(rollDiceButtonController);
    rollDiceButton.addChangeListener(rollDiceButtonController);
  }

  public void updateNumberOfDiceOnButton() {
    rollDiceButton.setText("Roll " + getNumberOfDiceSelected() + "D" + diceNumber);
  }
}
