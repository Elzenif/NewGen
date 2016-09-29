package commons.controller.entity;

import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.entity.items.RarityChangeListener;
import commons.controller.intf.ConstraintOptionRowController;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.model.entity.constraints.GlobalConstraints;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class EntityController<T extends Game> implements ConstraintOptionRowController {

  protected final GlobalConstraints globalConstraints;
  private final ConstraintsItemListener constraintsItemListener;
  private final RarityChangeListener<T> rarityChangeListener;
  protected GenerateEntityActionListener<T> generateEntityActionListener;

  protected EntityController(EntityOptionRow<T> entityOptionRow) {
    this.globalConstraints = new GlobalConstraints();
    this.constraintsItemListener = new ConstraintsItemListener(entityOptionRow);
    this.rarityChangeListener = new RarityChangeListener<>(this, entityOptionRow);
  }

  public GlobalConstraints getGlobalConstraints() {
    return globalConstraints;
  }

  @Override
  public ConstraintsItemListener getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public RarityChangeListener<T> getRarityChangeListener() {
    return rarityChangeListener;
  }

  public GenerateEntityActionListener<T> getGenerateEntityActionListener() {
    return generateEntityActionListener;
  }

  public abstract void updateRarityConstraint(GenericConstraint<EItemRarity> constraint);

}
