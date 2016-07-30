package nbk.model.utility.love;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ELoveDraw {

  ACTION(ELoveAction.class),
  TARGET(ELoveTarget.class),
  TOOL(ELoveTool.class),
  POSITION(ELovePosition.class)
  ;

  private final Class<? extends ILoveDraw> loveDrawClass;

  ELoveDraw(Class<? extends ILoveDraw> loveDrawClass) {
    this.loveDrawClass = loveDrawClass;
  }

  public Class<? extends ILoveDraw> getLoveDrawClass() {
    return loveDrawClass;
  }

  public static final String LOVE_DRAW_NAME = "LD";
}
