package commons.controller;

import commons.model.commons.GenerationConstraint;
import commons.view.commons.Result;
import commons.view.utils.OptionRow;
import commons.view.utils.ResultRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by Germain on 01/10/2016.
 */
public abstract class GenerateActionListener<OR extends OptionRow<RR>, RR extends ResultRow<R, S>, R extends Result<S>,
    S, GC extends GenerationConstraint>
    implements ActionListener {

  protected final OR optionRow;
  protected final RR resultRow;

  protected GenerateActionListener(OR optionRow, RR resultRow) {
    this.optionRow = optionRow;
    this.resultRow = resultRow;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    resultRow.clearResults();
    resultRow.setResultsToPrint(generateResult(getConstraints()));
  }

  protected abstract GC getConstraints();

  protected abstract Collection<R> generateResult(GC constraint);
}
