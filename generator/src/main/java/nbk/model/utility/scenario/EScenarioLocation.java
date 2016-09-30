package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioLocation implements IScenarioDraw {

  SD1("une grotte à proximité"),
  SD2("une grotte à proximité"),
  SD3("une grotte à proximité"),
  SD4("une grotte à proximité"),
  SD5("une grotte à proximité"),
  SD6("une grotte à proximité"),
  SD7("une grotte à proximité"),
  SD8("une grotte à proximité"),
  SD9("une grotte à proximité"),
  SD10("une grotte à proximité"),
  SD11("une grotte à proximité"),
  SD12("une grotte à proximité"),
  SD13("une grotte à proximité"),
  SD14("une grotte à proximité"),
  SD15("une grotte à proximité"),
  SD16("une grotte à proximité"),
  SD17("une grotte à proximité"),
  SD18("une grotte à proximité"),
  SD19("une grotte à proximité"),
  SD20("une grotte à proximité"),;

  private final String sentence;

  EScenarioLocation(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
