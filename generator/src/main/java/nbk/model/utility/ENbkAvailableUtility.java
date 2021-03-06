package nbk.model.utility;

import commons.model.utility.IAvailableUtility;
import commons.utils.StringUtils;
import nbk.model.commons.NbkGame;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ENbkAvailableUtility implements IAvailableUtility<NbkGame> {
  LOVE_ROLEPLAY {
    @Override
    public String getName() {
      return resourceBundle.getString("row.love");
    }
  }, SCENARIO;


  @Override
  public String getName() {
    return StringUtils.capitalizeFirstLetter(toString(), true);
  }
}
