package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioGuy implements IScenarioDraw {
  SD1("un garde du village"),
  SD2("un garde du village"),
  SD3("un garde du village"),
  SD4("un garde du village"),
  SD5("un garde du village"),
  SD6("un garde du village"),
  SD7("un garde du village"),
  SD8("un garde du village"),
  SD9("un garde du village"),
  SD10("un garde du village"),
  SD11("un garde du village"),
  SD12("un garde du village"),
  SD13("un garde du village"),
  SD14("un garde du village"),
  SD15("un garde du village"),
  SD16("un garde du village"),
  SD17("un garde du village"),
  SD18("un garde du village"),
  SD19("un garde du village"),
  SD20("un garde du village"),;

  private final String sentence;

  EScenarioGuy(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
