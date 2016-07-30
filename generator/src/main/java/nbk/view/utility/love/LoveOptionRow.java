package nbk.view.utility.love;

import commons.view.utility.UtilityOptionRow;
import commons.view.utility.UtilityResultRow;
import commons.view.utils.Constants;
import commons.view.utils.ConstraintPanel;
import commons.view.utils.HasConstraintPanel;
import nbk.controller.utility.love.LoveController;
import nbk.model.commons.NbkGame;
import nbk.model.utility.ENbkAvailableUtility;
import nbk.model.utility.love.ELoveDraw;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveOptionRow extends UtilityOptionRow<NbkGame> implements HasConstraintPanel {

  private final JPanel useDicesPanel;
  private final JLabel useDicesLabel;
  private final JCheckBox useDicesCheckBox;

  private final ConstraintPanel constraintPanel;

  private final Map<ELoveDraw, SpinnerNumberModel> loveDrawMap;

  private final JButton makeLoveButton;

  private LoveController loveController;

  public LoveOptionRow() {
    super(ENbkAvailableUtility.LOVE_ROLEPLAY.getName());

    useDicesLabel = new JLabel("Dice");
    useDicesLabel.setAlignmentX(CENTER_ALIGNMENT);
    useDicesCheckBox = new JCheckBox();
    useDicesCheckBox.setAlignmentX(CENTER_ALIGNMENT);
    useDicesPanel = new JPanel();
    useDicesPanel.setLayout(new BoxLayout(useDicesPanel, BoxLayout.Y_AXIS));
    useDicesPanel.add(useDicesLabel);
    useDicesPanel.add(useDicesCheckBox);
    add(useDicesPanel);

    constraintPanel = new ConstraintPanel();
    constraintPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    loveDrawMap = new LinkedHashMap<>(ELoveDraw.values().length);
    for (ELoveDraw loveDraw : ELoveDraw.values()) {
      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 20, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setAlignmentX(LEFT_ALIGNMENT);
      loveDrawMap.put(loveDraw, spinnerNumberModel);
      constraintPanel.add(jSpinner);
    }

    add(constraintPanel);
    updateConstraintsAbility(false);

    makeLoveButton = new JButton("Make Love");
    add(makeLoveButton);
  }

  @Override
  public void setControllers(UtilityResultRow resultRow) {
    loveController = new LoveController(this, resultRow);
    useDicesCheckBox.addItemListener(loveController.getConstraintsItemListener());
    makeLoveButton.addActionListener(loveController.getMakeLoveActionListener());
  }

  @Override
  public boolean isConstraintsCheckBoxSelected() {
    return useDicesCheckBox.isSelected();
  }

  @Override
  public void updateConstraintsAbility(boolean checkBoxSelected) {
    constraintPanel.setEnabled(checkBoxSelected);
  }

  public int getLoveDrawDiceScore(ELoveDraw loveDraw) {
    return loveDrawMap.get(loveDraw).getNumber().intValue();
  }
}
