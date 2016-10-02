package commons.controller;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.model.commons.GenerationConstraint;

/**
 * Created by Germain on 02/10/2016.
 */
public abstract class AbstractOptionRowController<GC extends GenerationConstraint>
    implements ConstraintOptionRowController<GC> {

  protected final GC generationConstraint;
  private final ConstraintsItemListener constraintsItemListener;
  protected GenerateActionListener generateActionListener;

  protected AbstractOptionRowController(ConstraintsItemListener constraintsItemListener,
                                        GC generationConstraint) {
    this.constraintsItemListener = constraintsItemListener;
    this.generationConstraint = generationConstraint;
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  @Override
  public GenerateActionListener getGenerateActionListener() {
    return generateActionListener;
  }

  @Override
  public GC getGenerationConstraint() {
    return generationConstraint;
  }
}
