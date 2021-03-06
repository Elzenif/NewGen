package commons.view.dice;

import commons.Constants;
import commons.controller.dice.AddScoreCheckBoxItemListener;
import commons.controller.dice.AddScoreSpinnerChangeListener;
import commons.controller.dice.NumberOfDiceChangeListener;
import commons.controller.dice.RollDiceActionListener;
import commons.controller.dice.TestCheckBoxListener;
import commons.model.dice.EDiceNumber;
import commons.utils.EOperator;
import commons.utils.MathUtils;
import commons.utils.StringUtils;
import commons.view.commons.options.BorderLayoutOptionRow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.text.MessageFormat;
import java.util.Arrays;

import static commons.Constants.JPANEL_HGAP;
import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 21/05/2016.
 */
public class DiceOptionRow extends BorderLayoutOptionRow<DiceResultRow> {

  @SuppressWarnings("SpellCheckingInspection")
  private final int JBUTTON_SIZE = resourceBundle.getString("row.dice.buttonTextMax").length();

  private final EDiceNumber diceNumber;

  private final JSpinner numberOfDiceSpinner;
  private final SpinnerNumberModel numberOfDiceModel;

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
    super(MathUtils.maxLength(Arrays.asList(EDiceNumber.values())), diceNumber.getName());
    this.diceNumber = diceNumber;

    numberOfDiceModel = new SpinnerNumberModel(1, 0, 20, 1);
    numberOfDiceSpinner = new JSpinner(numberOfDiceModel);
    leftPanel.add(numberOfDiceSpinner);

    leftPanel.add(infoLabel);

    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    addScoreCheckBox = new JCheckBox(resourceBundle.getString("row.dice.add"));
    addScoreCheckBox.setAlignmentX(LEFT_ALIGNMENT);
    addScoreModel = new SpinnerNumberModel(1, 1, 99, 1);
    addScoreSpinner = new JSpinner(addScoreModel);
    addScoreSpinner.setEnabled(false);
    addScoreSpinner.setAlignmentX(LEFT_ALIGNMENT);
    jPanel1.add(addScoreCheckBox);
    jPanel1.add(addScoreSpinner);
    centerPanel.add(jPanel1);

    JPanel jPanel2 = new JPanel();
    jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
    testCheckBox = new JCheckBox(resourceBundle.getString("row.dice.test"));
    testCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    JPanel jPanel21 = new JPanel();
    jPanel21.setLayout(new FlowLayout(FlowLayout.LEFT, JPANEL_HGAP / 2, 0));
    testComboBox = new JComboBox<>(EOperator.values());
    testComboBox.setEnabled(false);
    testModel = new SpinnerNumberModel(diceNumber.getDiceNumber() / 2, 1, 99, 1);
    testSpinner = new JSpinner(testModel);
    testSpinner.setEnabled(false);
    jPanel21.add(testComboBox);
    jPanel21.add(testSpinner);
    jPanel2.add(testCheckBox);
    jPanel2.add(jPanel21);
    centerPanel.add(jPanel2);

    JPanel jPanel3 = new JPanel();
    jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
    sumCheckBox = new JCheckBox(resourceBundle.getString("row.dice.sum"));
    jPanel3.add(sumCheckBox);
    meanCheckBox = new JCheckBox(resourceBundle.getString("row.dice.mean"));
    jPanel3.add(meanCheckBox);
    centerPanel.add(jPanel3);

    rollDiceButton = new JButton();
    rollDiceButton.setFont(Constants.DAUPHINN_FONT);
    updateTextButton();
    rightPanel.add(rollDiceButton);
  }

  @Override
  public void setControllers(DiceResultRow diceResultRow) {
    rollDiceButton.addActionListener(new RollDiceActionListener(diceNumber.getDiceNumber(), this, diceResultRow));
    numberOfDiceSpinner.addChangeListener(new NumberOfDiceChangeListener(this));
    addScoreCheckBox.addItemListener(new AddScoreCheckBoxItemListener(this));
    addScoreSpinner.addChangeListener(new AddScoreSpinnerChangeListener(this));
    testCheckBox.addItemListener(new TestCheckBoxListener(this));
  }

  public int getNumberOfDiceSelected() {
    return numberOfDiceModel.getNumber().intValue();
  }

  public void updateTextButton() {
    String s = MessageFormat.format(resourceBundle.getString("row.dice.roll"), getNumberOfDiceSelected(), diceNumber.getName());
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
