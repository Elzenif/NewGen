package mvc.view.dice;

import mvc.controller.dice.AddScoreCheckBoxItemListener;
import mvc.controller.dice.AddScoreSpinnerChangeListener;
import mvc.controller.dice.NumberOfDiceChangeListener;
import mvc.controller.dice.RollDiceActionListener;
import mvc.view.Constants;
import utils.StringUtils;

import javax.swing.BoxLayout;
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

  private final int JLABEL_SIZE = 5;
  private final int JBUTTON_SIZE = 14;

  private int diceNumber;

  private JLabel infoLabel;

  private JSpinner numberOfDiceSpinner;
  private SpinnerNumberModel numberOfDiceModel;

  private JCheckBox sumCheckBox;

  private JCheckBox meanCheckBox;

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

    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    addScoreCheckBox = new JCheckBox("Add score");
    addScoreCheckBox.setAlignmentX(RIGHT_ALIGNMENT);
    addScoreModel = new SpinnerNumberModel(1, 1, 99, 1);
    addScoreSpinner = new JSpinner(addScoreModel);
    addScoreSpinner.setEnabled(false);
    addScoreSpinner.setAlignmentX(RIGHT_ALIGNMENT);
    jPanel1.add(addScoreCheckBox);
    jPanel1.add(addScoreSpinner);
    add(jPanel1);

    JPanel jPanel2 = new JPanel();
    jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
    sumCheckBox = new JCheckBox("Sum");
    jPanel2.add(sumCheckBox);
    meanCheckBox = new JCheckBox("Mean");
    jPanel2.add(meanCheckBox);
    add(jPanel2);

    rollDiceButton = new JButton();
    updateTextButton();
    add(rollDiceButton);
  }

  // TODO add a comparison test to rolls

  void setControllers(DiceResultRow diceResultRow) {
    rollDiceButton.addActionListener(new RollDiceActionListener(diceNumber, this, diceResultRow));
    numberOfDiceSpinner.addChangeListener(new NumberOfDiceChangeListener(this));
    addScoreCheckBox.addItemListener(new AddScoreCheckBoxItemListener(this));
    addScoreSpinner.addChangeListener(new AddScoreSpinnerChangeListener(this));
  }

  public int getNumberOfDiceSelected() {
    return numberOfDiceModel.getNumber().intValue();
  }

  public void updateTextButton() {
    String s = "Roll " + getNumberOfDiceSelected() + "D" + diceNumber;
    if (isAddScoreCheckBoxSelected()) {
      s += "+" + getAddScore();
    }
    rollDiceButton.setText(StringUtils.center(JBUTTON_SIZE, s));
  }

  public boolean sumCheckBoxIsSelected() {
    return sumCheckBox.isSelected();
  }

  public boolean meanCheckBoxIsSelected() {
    return meanCheckBox.isSelected();
  }

  public boolean isAddScoreCheckBoxSelected() {
    return addScoreCheckBox.isSelected();
  }

  public void updateAddScoreSpinnerAbility() {
    addScoreSpinner.setEnabled(isAddScoreCheckBoxSelected());
  }

  public int getAddScore() {
    return isAddScoreCheckBoxSelected() ? addScoreModel.getNumber().intValue() : 0;
  }
}
