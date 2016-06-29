package nbk.model.entity.utils.fields;

import nbk.model.entity.enums.ENbkQuality;

/**
 * Created by Germain on 29/06/2016.
 */
@FunctionalInterface
public interface HasQuality {

  ENbkQuality getQuality();
}
