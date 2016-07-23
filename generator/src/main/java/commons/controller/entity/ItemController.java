package commons.controller.entity;

import commons.model.commons.Game;
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
  private final GenerateItemActionListener<T> generateItemActionListener;

  protected ItemController(EntityOptionRow<T> entityOptionRow,
                           GenerateItemActionListener<T> generateItemActionListener) {
    this.entityOptionRow = entityOptionRow;
    this.globalConstraints = new GlobalConstraints();
    this.constraintsItemListener = new ConstraintsItemListener<>(entityOptionRow);
    this.rarityChangeListener = new RarityChangeListener<>(entityOptionRow);
    this.generateItemActionListener = generateItemActionListener;
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
}
