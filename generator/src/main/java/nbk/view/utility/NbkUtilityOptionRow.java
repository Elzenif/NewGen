package nbk.view.utility;

import commons.model.utility.IUtilityDrawKey;
import commons.utils.MathUtils;
import commons.view.utility.UtilityOptionRow;
import nbk.model.utility.ENbkAvailableUtility;

import java.util.Arrays;

/**
 * Created by Germain on 30/09/2016.
 */
public abstract class NbkUtilityOptionRow<K extends IUtilityDrawKey> extends UtilityOptionRow<K> {

  protected NbkUtilityOptionRow(String name) {
    super(MathUtils.maxLength(Arrays.asList(ENbkAvailableUtility.values())), name);
  }
}
