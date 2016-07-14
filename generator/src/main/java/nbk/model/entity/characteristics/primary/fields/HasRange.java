package nbk.model.entity.characteristics.primary.fields;

import nbk.model.entity.characteristics.primary.enums.ERange;

/**
 * Created by Germain on 28/06/2016.
 */
@FunctionalInterface
public interface HasRange {

  ERange getRange();
}
