package commons.view.dice;

import commons.controller.dice.AddScoreCheckBoxItemListener;
import commons.controller.dice.AddScoreSpinnerChangeListener;
import commons.controller.dice.NumberOfDiceChangeListener;
import commons.controller.dice.RollDiceActionListener;
import commons.controller.dice.TestCheckBoxListener;
import commons.model.dice.EDiceNumber;
import commons.utils.EOperator;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.utils.Constants;
import commons.view.utils.OptionRow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.util.Arrays;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceOptionRow extends OptionRow<DiceResultRow> {

  private static final int JLABEL_SIZE = MathUtils.maxLength(Arrays.asList(EDiceNumber.values()));
  private final int JBUTTON_SIZE = "Roll 99D100+99".length();

  private final EDiceNumber diceNumber;

  private final JSpinner numberOfDiceSpinner;
  private final SpinnerNumberModel numberOfDiceModel;

  private final JLabel infoLabel;

  private final JCheckBox addScoreCheckBox;
  private final JSpinner addScoreSpinner;
  private final SpinnerNumberModel addScoreModel;

  private final JCheckBox testCheckBox;
  private final JComboBox<EOperator> testComboBox;
  private final JSpinner testSpinner;
  private final SpinnerNumberModel testModel;


  private final JCheckBox sumCheckBox;
  private final JCheckBox meanCheckBox;

  private final JButton rollDiceButton;

  public DiceOptionRow(EDiceNumber diceNumber) {
    super();
    this.diceNumber = diceNumber;

    numberOfDiceModel = new SpinnerNumberModel(1, 0, 20, 1);
    numberOfDiceSpinner = new JSpinner(numberOfDiceModel);
    add(numberOfDiceSpinner);

    infoLabel = new JLabel(StringUtils.leftAlign(JLABEL_SIZE, diceNumber.getName()));
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
    testModel = new SpinnerNumberModel(diceNumber.getDiceNumber() / 2, 1, 99, 1);
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

  @Override
  public void setControllers(DiceResultRow diceResultRow) {
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
    String s = "Roll " + getNumberOfDiceSelected() + diceNumber.getName();
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
