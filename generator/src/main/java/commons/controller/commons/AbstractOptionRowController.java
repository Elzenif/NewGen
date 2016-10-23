package commons.controller.commons;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.model.commons.constraints.GenerationConstraints;

/**
 * Created by Germain on 02/10/2016.
 */
public abstract class AbstractOptionRowController
    implements ConstraintOptionRowController {

  protected final GenerationConstraints generationConstraints;
  private final ConstraintsItemListener constraintsItemListener;
  protected GenerateActionListener generateActionListener;

  protected AbstractOptionRowController(ConstraintsItemListener constraintsItemListener) {
    this.constraintsItemListener = constraintsItemListener;
    this.generationConstraints = new GenerationConstraints();
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  @Override
  public GenerateActionListener getGenerateActionListener() {
    return generateActionListener;
  }

  public GenerationConstraints getGenerationConstraints() {
    return generationConstraints;
  }
}
