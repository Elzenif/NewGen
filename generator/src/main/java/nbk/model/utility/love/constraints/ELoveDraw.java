package nbk.model.utility.love.constraints;

import commons.model.utility.constraints.IUtilityDrawKey;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ELoveDraw implements IUtilityDrawKey {

  ACTION,
  TARGET,
  TOOL,
  POSITION
  ;

  public static final String LOVE_DRAW_NAME = "LD";
}
