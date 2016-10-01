package nbk.model.utility.scenario;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioLoot implements IScenarioDrawResult {

  SD1("1D100 PO par aventurier et par niveau"),
  SD2("25 PO par aventurier et par niveau"),
  SD3("un lingot de Béryllium"),
  SD4("un équipement de grande valeur"),
  SD5("une arme ou armure par aventurier"),
  SD6("50 PO par aventurier"),
  SD7("200 PO pour la compagnie"),
  SD8("500 PO pour la compagnie"),
  SD9("une potion pour chaque aventurier"),
  SD10("un objet par aventurier");

  private final String sentence;

  EScenarioLoot(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
