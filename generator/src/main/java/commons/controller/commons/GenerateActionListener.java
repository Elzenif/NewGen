package commons.controller.commons;

import commons.model.commons.constraints.GenerationConstraints;
import commons.view.commons.options.ConstraintOptionRow;
import commons.view.commons.results.Result;
import commons.view.commons.results.ResultRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateActionListener<OR extends ConstraintOptionRow<RR>, RR extends ResultRow<R, S>,
    R extends Result<S>, S>
    implements ActionListener {

  protected final OR optionRow;
  protected final RR resultRow;
  private final AbstractOptionRowController controller;

  protected GenerateActionListener(OR optionRow, RR resultRow, AbstractOptionRowController controller) {
    this.optionRow = optionRow;
    this.resultRow = resultRow;
    this.controller = controller;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    resultRow.clearResults();
    resultRow.setResultsToPrint(generateResult(getConstraints()));
  }

  private GenerationConstraints getConstraints() {
    return (optionRow.isConstraintsCheckBoxSelected())
        ? controller.getGenerationConstraints()
        : new GenerationConstraints();
  }

  protected abstract Collection<R> generateResult(GenerationConstraints constraint);
}
