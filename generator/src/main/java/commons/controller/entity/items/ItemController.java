package commons.controller.entity.items;

import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.model.entity.constraints.GlobalConstraints;
import commons.view.entity.EntityOptionRow;

/**
 * Created by Germain on 23/07/2016.
 */
public abstract class ItemController<T extends Game> {

  protected final EntityOptionRow<T> entityOptionRow;
  protected final GlobalConstraints globalConstraints;
  private final ConstraintsItemListener<T> constraintsItemListener;
  private final RarityChangeListener<T> rarityChangeListener;
  protected GenerateItemActionListener<T> generateItemActionListener;

  protected ItemController(EntityOptionRow<T> entityOptionRow) {
    this.entityOptionRow = entityOptionRow;
    this.globalConstraints = new GlobalConstraints();
    this.constraintsItemListener = new ConstraintsItemListener<>(entityOptionRow);
    this.rarityChangeListener = new RarityChangeListener<>(this, entityOptionRow);
  }

  public GlobalConstraints getGlobalConstraints() {
    return globalConstraints;
  }

  public ConstraintsItemListener<T> getConstraintsItemListener() {
    return constraintsItemListener;
  }

  public RarityChangeListener<T> getRarityChangeListener() {
    return rarityChangeListener;
  }

  public GenerateItemActionListener<T> getGenerateItemActionListener() {
    return generateItemActionListener;
  }

  public abstract void updateRarityConstraint(GenericConstraint<ERarity> constraint);

}
