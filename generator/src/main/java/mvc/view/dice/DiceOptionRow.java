package mvc.view.dice;

import mvc.controller.dice.RollDiceController;
import mvc.view.Constants;
import utils.StringUtils;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceOptionRow extends JPanel {

  private final int JLABEL_SIZE = 4;
  private final int JBUTTON_SIZE = 11;

  private int diceNumber;

  private JLabel infoLabel;

  private JSpinner numberOfDiceSpinner;
  private SpinnerNumberModel numberOfDiceModel;

  private JCheckBox sumCheckBox;

  private JCheckBox addScoreCheckBox;
  private JSpinner addScoreSpinner;
  private SpinnerNumberModel addScoreModel;

  private JButton rollDiceButton;

  DiceOptionRow(int diceNumber) {
    this.diceNumber = diceNumber;
    setComponents();
  }

  private void setComponents() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    numberOfDiceModel = new SpinnerNumberModel(1, 0, 20, 1);
    numberOfDiceSpinner = new JSpinner(numberOfDiceModel);
    add(numberOfDiceSpinner);

    infoLabel = new JLabel(StringUtils.center(JLABEL_SIZE, "D" + diceNumber));
    add(infoLabel);

    sumCheckBox = new JCheckBox("Sum results");
    add(sumCheckBox);

    addScoreCheckBox = new JCheckBox("Add score");
    addScoreModel = new SpinnerNumberModel(1, 1, 99, 1);
    addScoreSpinner = new JSpinner(addScoreModel);
    addScoreSpinner.setEnabled(false);
    add(addScoreCheckBox);
    add(addScoreSpinner);

    rollDiceButton = new JButton(StringUtils.center(
            JBUTTON_SIZE, "Roll " + numberOfDiceModel.getNumber() + "D" + diceNumber));
    add(rollDiceButton);
  }

  void setController(RollDiceController rollDiceController) {
    rollDiceButton.addActionListener(rollDiceController);
    rollDiceButton.addChangeListener(rollDiceController);
  }

  public int getNumberOfDiceSelected() {
    return numberOfDiceModel.getNumber().intValue();
  }

  public void updateNumberOfDiceOnButton() {
    rollDiceButton.setText(StringUtils.center(
            JBUTTON_SIZE, "Roll " + getNumberOfDiceSelected() + "D" + diceNumber));
  }

  public boolean sumCheckBoxIsSelected() {
    return sumCheckBox.isSelected();
  }
}
