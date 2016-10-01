package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioBeginning implements IScenarioDrawResult {
  SD1("A la taverne,"),
  SD11("Dans une boutique,"),
  SD12("Au marché,"),
  SD13("Dans une ruelle,"),
  SD14("Dans la rue principale"),
  SD15("Dans une ferme,"),
  SD16("Au poste de garde,"),
  SD17("A l'auberge,"),
  SD18("A la poisonnerie,"),
  SD19("Sur la grand place,"),
  SD20("Sur un pont,");

  private final String sentence;

  EScenarioBeginning(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
