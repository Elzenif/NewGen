package tes.view.entity;

import commons.view.entity.EntityPanelEmbedded;
import tes.model.commons.TesGame;

/**
 * Created by Germain on 12/06/2016.
 */
public class TesEntityPanelEmbedded extends EntityPanelEmbedded<TesGame, ETesAvailableItem> {

  public TesEntityPanelEmbedded() {
    super(TesGame.getInstance(), ETesAvailableItem.values());
  }
}
