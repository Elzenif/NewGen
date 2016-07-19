package tes.view.entity;

import commons.view.entity.EntityOptionRow;
import tes.model.commons.TesGame;

/**
 * Created by Germain on 09/06/2016.
 */
public class TesEntityOptionRow extends EntityOptionRow<TesGame> {

  TesEntityOptionRow(ETesAvailableItem availableItem) {
    super(availableItem, TesGame.getInstance());
  }

}
