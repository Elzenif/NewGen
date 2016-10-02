package commons.controller;

import commons.model.commons.GenerationConstraint;
import commons.view.commons.Result;
import commons.view.utils.ConstraintOptionRow;
import commons.view.utils.ResultRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateActionListener<OR extends ConstraintOptionRow<RR>, RR extends ResultRow<R, S>,
    R extends Result<S>, S, GC extends GenerationConstraint>
    implements ActionListener {

  protected final OR optionRow;
  protected final RR resultRow;
  protected final AbstractOptionRowController<GC> controller;

  protected GenerateActionListener(OR optionRow, RR resultRow, AbstractOptionRowController<GC> controller) {
    this.optionRow = optionRow;
    this.resultRow = resultRow;
    this.controller = controller;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    resultRow.clearResults();
    resultRow.setResultsToPrint(generateResult(getConstraints()));
  }

  protected final GC getConstraints() {
    return (optionRow.isConstraintsCheckBoxSelected())
        ? controller.getGenerationConstraint()
        : newConstraint();
  }

  protected abstract GC newConstraint();

  protected abstract Collection<R> generateResult(GC constraint);
}
