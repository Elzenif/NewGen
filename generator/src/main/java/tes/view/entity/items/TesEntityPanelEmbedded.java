package tes.view.entity.items;

import commons.view.entity.EntityPanelEmbedded;
import tes.model.commons.TesGame;

/**
 * Created by Germain on 12/06/2016.
 */
public class TesEntityPanelEmbedded extends EntityPanelEmbedded<TesGame, ETesAvailableEntityOptionRow> {

  public TesEntityPanelEmbedded() {
    super(ETesAvailableEntityOptionRow.values());
  }
}
