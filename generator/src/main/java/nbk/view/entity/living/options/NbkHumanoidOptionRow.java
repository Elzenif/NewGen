package nbk.view.entity.living.options;

import commons.utils.Pair;
import commons.view.entity.EntityResultRow;
import commons.view.utils.ConstraintPanel;
import nbk.controller.entity.living.NbkHumanoidController;
import nbk.model.entity.living.ENbkAvailableLivings;
import nbk.model.entity.living.characteristics.primary.EStat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import static commons.view.utils.Constants.resourceBundle;

/**
 * Created by Germain on 28/08/2016.
 */
public class NbkHumanoidOptionRow extends NbkLivingOptionRow {

  private final Map<EStat, Pair<JSpinner, SpinnerNumberModel>> statMap;
  private final int defaultValue = 10;

  NbkHumanoidOptionRow() {
    super(ENbkAvailableLivings.HUMANOID);

    statMap = new LinkedHashMap<>(EStat.values().length);
    for (EStat stat : EStat.values()) {
      ConstraintPanel cPanel = new ConstraintPanel();
      cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));

      JLabel jLabel = new JLabel(stat.toString());
      jLabel.setAlignmentX(LEFT_ALIGNMENT);

      SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(defaultValue, 8, 13, 1);
      JSpinner jSpinner = new JSpinner(spinnerNumberModel);
      jSpinner.setAlignmentX(LEFT_ALIGNMENT);
      jSpinner.setMaximumSize(jSpinner.getPreferredSize());
      statMap.put(stat, new Pair<>(jSpinner, spinnerNumberModel));

      cPanel.add(jLabel);
      cPanel.add(jSpinner);
      constraintPanel.add(cPanel);
    }

    finalizeRowConstruction(MessageFormat.format(resourceBundle.getString("tooltip.entity.generate"), name));
  }

  @Override
  public void setControllers(EntityResultRow resultRow) {
    super.setControllers(new NbkHumanoidController(this, resultRow, defaultValue));
    statMap.forEach((stat, pair) ->
        pair.getLeft().addChangeListener(((NbkHumanoidController) controller).getDrawChangeListener(stat)));
  }
}
