package nbk.model.entity.living;

import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Germain on 29/08/2016.
 */
public class NbkLivingUtils {

  public static Set<ENbkOrigin> listAvailbleOrigins() {
    return EnumSet.allOf(ENbkOrigin.class);
  }
}
