package commons.controller.entity;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.entity.items.RarityChangeListener;
import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.model.entity.constraints.GlobalConstraints;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class EntityController<G extends Game> extends AbstractOptionRowController<GlobalConstraints> {

  private final RarityChangeListener<G> rarityChangeListener;

  protected EntityController(EntityOptionRow<G> entityOptionRow) {
    super(new ConstraintsItemListener(entityOptionRow), new GlobalConstraints());
    this.rarityChangeListener = new RarityChangeListener<>(this, entityOptionRow);
  }

  public RarityChangeListener<G> getRarityChangeListener() {
    return rarityChangeListener;
  }

  public abstract void updateRarityConstraint(GenericConstraint<EItemRarity> constraint);

}
