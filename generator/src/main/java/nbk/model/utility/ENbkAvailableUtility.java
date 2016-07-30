package nbk.model.utility;

import commons.model.utility.IAvailableUtility;
import commons.utils.StringUtils;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ENbkAvailableUtility implements IAvailableUtility {
  LOVE_ROLEPLAY {
    @Override
    public String getName() {
      return "Love";
    }
  };


  @Override
  public String getName() {
    return StringUtils.capitalizeFirstLetter(toString(), true);
  }
}
