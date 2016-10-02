package commons.controller.intf;

import commons.controller.GenerateActionListener;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.model.commons.GenerationConstraint;

/**
 * Created by Germain on 29/09/2016.
 */
public interface ConstraintOptionRowController<GC extends GenerationConstraint> {

  ConstraintsItemListener getConstraintsItemListener();

  GenerateActionListener getGenerateActionListener();

  GC getGenerationConstraint();
}
