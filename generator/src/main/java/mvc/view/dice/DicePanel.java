package mvc.view.dice;

import mvc.controller.dice.RollDiceButtonController;
import mvc.view.Constants;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends JPanel {

  // view
  private JPanel leftPanel;
  private JButton rollDiceButton;
  private JPanel rightPanel;
  private JLabel resultDice;

  // model

  // controller
  private RollDiceButtonController rollDiceButtonController;

  private final int NB_ROWS = 4;
  private final int NB_COLS = 3;

  public DicePanel() {
    setView();
    setModel();
    setController();
  }

  private void setView() {
    setLayout(new GridLayout(0, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    setLeftPanel();
    add(leftPanel);

    setRigthPanel();
    add(rightPanel);
  }

  private void setLeftPanel() {
    leftPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    leftPanel.setBorder(BorderFactory.createTitledBorder("Options"));

    rollDiceButton = new JButton("Roll Dice");
    leftPanel.add(rollDiceButton);
  }

  private void setRigthPanel() {
    rightPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    rightPanel.setBorder(BorderFactory.createTitledBorder("Result"));

    resultDice = new JLabel();
    rightPanel.add(resultDice);
  }

  private void setModel() {

  }

  private void setController() {
    rollDiceButtonController = new RollDiceButtonController(resultDice);
    rollDiceButton.addActionListener(rollDiceButtonController);

  }
}
