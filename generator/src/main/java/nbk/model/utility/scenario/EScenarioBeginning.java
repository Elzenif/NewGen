package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioBeginning implements IScenarioDraw {
  SD1("A la taverne,"),
  SD2("A la taverne,"),
  SD3("A la taverne,"),
  SD4("A la taverne,"),
  SD5("A la taverne,"),
  SD6("A la taverne,"),
  SD7("A la taverne,"),
  SD8("A la taverne,"),
  SD9("A la taverne,"),
  SD10("A la taverne,"),
  SD11("A la taverne,"),
  SD12("A la taverne,"),
  SD13("A la taverne,"),
  SD14("A la taverne,"),
  SD15("A la taverne,"),
  SD16("A la taverne,"),
  SD17("A la taverne,"),
  SD18("A la taverne,"),
  SD19("A la taverne,"),
  SD20("A la taverne,");

  private final String sentence;

  EScenarioBeginning(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }


}
