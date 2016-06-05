package mvc.view.dice;

import mvc.controller.dice.AddScoreCheckBoxItemListener;
import mvc.controller.dice.AddScoreSpinnerChangeListener;
import mvc.controller.dice.NumberOfDiceChangeListener;
import mvc.controller.dice.RollDiceActionListener;
import mvc.controller.dice.TestCheckBoxListener;
import mvc.view.commons.Constants;
import mvc.view.commons.PanelRow;
import utils.EOperator;
import utils.StringUtils;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceOptionRow extends PanelRow {

  private final int JLABEL_SIZE = 5;
  private final int JBUTTON_SIZE = 14;

  private final int diceNumber;

  private JSpinner numberOfDiceSpinner;
  private SpinnerNumberModel numberOfDiceModel;

  private JLabel infoLabel;

  private JCheckBox addScoreCheckBox;
  private JSpinner addScoreSpinner;
  private SpinnerNumberModel addScoreModel;

  private JCheckBox testCheckBox;
  private JComboBox<EOperator> testComboBox;
  private JSpinner testSpinner;
  private SpinnerNumberModel testModel;


  private JCheckBox sumCheckBox;
  private JCheckBox meanCheckBox;

  private JButton rollDiceButton;

  DiceOptionRow(int diceNumber) {
    super();
    this.diceNumber = diceNumber;
    setComponents();
  }

  private void setComponents() {
    numberOfDiceModel = new SpinnerNumberModel(1, 0, 20, 1);
    numberOfDiceSpinner = new JSpinner(numberOfDiceModel);
    add(numberOfDiceSpinner);

    infoLabel = new JLabel(StringUtils.center(JLABEL_SIZE, "D" + diceNumber));
    add(infoLabel);

    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    addScoreCheckBox = new JCheckBox("Add");
    addScoreCheckBox.setAlignmentX(LEFT_ALIGNMENT);
    addScoreModel = new SpinnerNumberModel(1, 1, 99, 1);
    addScoreSpinner = new JSpinner(addScoreModel);
    addScoreSpinner.setEnabled(false);
    addScoreSpinner.setAlignmentX(LEFT_ALIGNMENT);
    jPanel1.add(addScoreCheckBox);
    jPanel1.add(addScoreSpinner);
    add(jPanel1);

    JPanel jPanel2 = new JPanel();
    jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
    testCheckBox = new JCheckBox("Test");
    testCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    JPanel jPanel21 = new JPanel();
    jPanel21.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP / 2, 0));
    testComboBox = new JComboBox<>(EOperator.values());
    testComboBox.setEnabled(false);
    testModel = new SpinnerNumberModel(diceNumber / 2, 1, 99, 1);
    testSpinner = new JSpinner(testModel);
    testSpinner.setEnabled(false);
    jPanel21.add(testComboBox);
    jPanel21.add(testSpinner);
    jPanel2.add(testCheckBox);
    jPanel2.add(jPanel21);
    add(jPanel2);

    JPanel jPanel3 = new JPanel();
    jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
    sumCheckBox = new JCheckBox("Sum");
    jPanel3.add(sumCheckBox);
    meanCheckBox = new JCheckBox("Mean");
    jPanel3.add(meanCheckBox);
    add(jPanel3);

    rollDiceButton = new JButton();
    updateTextButton();
    add(rollDiceButton);
  }

  void setControllers(DiceResultRow diceResultRow) {
    rollDiceButton.addActionListener(new RollDiceActionListener(diceNumber, this, diceResultRow));
    numberOfDiceSpinner.addChangeListener(new NumberOfDiceChangeListener(this));
    addScoreCheckBox.addItemListener(new AddScoreCheckBoxItemListener(this));
    addScoreSpinner.addChangeListener(new AddScoreSpinnerChangeListener(this));
    testCheckBox.addItemListener(new TestCheckBoxListener(this));
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

  private boolean isAddScoreCheckBoxSelected() {
    return addScoreCheckBox.isSelected();
  }

  public void updateAddScoreSpinnerAbility() {
    addScoreSpinner.setEnabled(isAddScoreCheckBoxSelected());
  }

  public int getAddScore() {
    return isAddScoreCheckBoxSelected() ? addScoreModel.getNumber().intValue() : 0;
  }

  public boolean isTestCheckBoxSelected() {
    return testCheckBox.isSelected();
  }

  public void updateTestSpinnerAndComboBoxAbility() {
    testSpinner.setEnabled(isTestCheckBoxSelected());
    testComboBox.setEnabled(isTestCheckBoxSelected());
  }

  public int getTestSpinnerValue() {
    return testModel.getNumber().intValue();
  }

  public EOperator getTestComboBoxOperator() {
    return (EOperator) testComboBox.getSelectedItem();
  }
}
