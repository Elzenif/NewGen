package mvc.view.dice;

import mvc.controller.dice.RollDiceButtonController;
import mvc.view.Constants;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Germain on 07/05/2016.
 */
public class DicePanel extends JPanel {

  // view
  private JPanel leftPanel;
  private DiceOptionRow d6OptionRow;

  private JPanel rightPanel;
  private DiceResultRow d6ResultRow;

  // model

  // controller
  private RollDiceButtonController rollDiceButtonController;

  private final int NB_ROWS = 8;
  private final int NB_COLS_LEFT = 1;
  private final int NB_COLS_RIGHT = 2;

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
    leftPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS_LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    leftPanel.setBorder(BorderFactory.createTitledBorder("Options"));

    d6OptionRow = new DiceOptionRow(6);
    leftPanel.add(d6OptionRow);
  }

  private void setRigthPanel() {
    rightPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS_RIGHT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    rightPanel.setBorder(BorderFactory.createTitledBorder("Result"));

    d6ResultRow = new DiceResultRow(6);
    rightPanel.add(d6ResultRow);
  }


  private void setModel() {

  }

  private void setController() {
    rollDiceButtonController = new RollDiceButtonController(d6OptionRow, d6ResultRow);
    d6OptionRow.setController(rollDiceButtonController);
  }
}
