package nbk.model.entity.characteristics.primary.enums;

import nbk.model.entity.characteristics.primary.fields.HasRange;

/**
 * Created by Germain on 14/07/2016.
 */
public enum ERange implements HasRange {

  CLOSE,
  LONG;

  @Override
  public ERange getRange() {
    return this;
  }
}
