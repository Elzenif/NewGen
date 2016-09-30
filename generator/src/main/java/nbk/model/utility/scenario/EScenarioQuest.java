package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioQuest implements IScenarioDraw {

  SD1("sauver une connaissance détenu par des brigands"),
  SD2("sauver une connaissance détenu par des brigands"),
  SD3("sauver une connaissance détenu par des brigands"),
  SD4("sauver une connaissance détenu par des brigands"),
  SD5("sauver une connaissance détenu par des brigands"),
  SD6("sauver une connaissance détenu par des brigands"),
  SD7("sauver une connaissance détenu par des brigands"),
  SD8("sauver une connaissance détenu par des brigands"),
  SD9("sauver une connaissance détenu par des brigands"),
  SD10("sauver une connaissance détenu par des brigands"),
  SD11("sauver une connaissance détenu par des brigands"),
  SD12("sauver une connaissance détenu par des brigands"),
  SD13("sauver une connaissance détenu par des brigands"),
  SD14("sauver une connaissance détenu par des brigands"),
  SD15("sauver une connaissance détenu par des brigands"),
  SD16("sauver une connaissance détenu par des brigands"),
  SD17("sauver une connaissance détenu par des brigands"),
  SD18("sauver une connaissance détenu par des brigands"),
  SD19("sauver une connaissance détenu par des brigands"),
  SD20("sauver une connaissance détenu par des brigands"),;

  private final String sentence;

  EScenarioQuest(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
