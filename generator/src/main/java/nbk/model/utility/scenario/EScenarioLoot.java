package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioLoot implements IScenarioDraw {

  SD1("1D100PO par aventurier et par niveau"),
  SD2("1D100PO par aventurier et par niveau"),
  SD3("1D100PO par aventurier et par niveau"),
  SD4("1D100PO par aventurier et par niveau"),
  SD5("1D100PO par aventurier et par niveau"),
  SD6("1D100PO par aventurier et par niveau"),
  SD7("1D100PO par aventurier et par niveau"),
  SD8("1D100PO par aventurier et par niveau"),
  SD9("1D100PO par aventurier et par niveau"),
  SD10("1D100PO par aventurier et par niveau"),
  SD11("1D100PO par aventurier et par niveau"),
  SD12("1D100PO par aventurier et par niveau"),
  SD13("1D100PO par aventurier et par niveau"),
  SD14("1D100PO par aventurier et par niveau"),
  SD15("1D100PO par aventurier et par niveau"),
  SD16("1D100PO par aventurier et par niveau"),
  SD17("1D100PO par aventurier et par niveau"),
  SD18("1D100PO par aventurier et par niveau"),
  SD19("1D100PO par aventurier et par niveau"),
  SD20("1D100PO par aventurier et par niveau"),;

  private final String sentence;

  EScenarioLoot(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
