package commons.controller.intf;

import commons.controller.commons.GenerateActionListener;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.model.commons.constraints.GenerationConstraints;

/**
 * Created by Germain on 29/09/2016.
 */
public interface ConstraintOptionRowController {

  ConstraintsItemListener getConstraintsItemListener();

  GenerateActionListener getGenerateActionListener();

  GenerationConstraints getGenerationConstraints();
}
