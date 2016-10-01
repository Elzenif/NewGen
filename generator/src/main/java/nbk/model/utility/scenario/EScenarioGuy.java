package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioGuy implements IScenarioDrawResult {
  SD1("un garde du village"),
  SD2("une grand-mère"),
  SD3("une jeune demoiselle"),
  SD4("un noble"),
  SD5("un mercenaire blessé"),
  SD6("un jeune enfant"),
  SD7("un tavernier"),
  SD8("un aubergiste"),
  SD9("un marchand"),
  SD10("un explorateur"),
  SD11("un magicien"),
  SD12("un alchimiste"),
  SD13("un forgeron"),
  SD14("un viellard"),
  SD15("un fou"),
  SD16("un prédicateur"),
  SD17("un fermier"),
  SD18("un pêcheur"),
  SD19("un jeune aventurier"),
  SD20("un devin"),;

  private final String sentence;

  EScenarioGuy(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
