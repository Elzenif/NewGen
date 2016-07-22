package tes.view.entity;

import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.constraints.GenericConstraint;
import commons.view.entity.EntityOptionRow;
import tes.model.commons.TesGame;
import tes.model.entity.items.ETesAvailableItem;

/**
 * Created by Germain on 09/06/2016.
 */
public class TesEntityOptionRow extends EntityOptionRow<TesGame> {

  TesEntityOptionRow(ETesAvailableItem availableItem) {
    super(availableItem, TesGame.getInstance());
  }

  @Override
  public void updateRarityConstraint(GenericConstraint<ERarity> constraint) {

  }
}
