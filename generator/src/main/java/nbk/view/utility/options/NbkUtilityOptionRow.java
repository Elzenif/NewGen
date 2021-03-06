package nbk.view.utility.options;

import commons.utils.MathUtils;
import commons.view.utility.UtilityOptionRow;
import nbk.model.utility.ENbkAvailableUtility;

import java.util.Arrays;

/**
 * Created by Germain on 30/09/2016.
 */
public abstract class NbkUtilityOptionRow extends UtilityOptionRow {

  protected NbkUtilityOptionRow(String name) {
    super(MathUtils.maxLength(Arrays.asList(ENbkAvailableUtility.values())), name);
  }
}
