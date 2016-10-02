package nbk.model.utility.scenario.constraints;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioQuest implements IScenarioDrawResult {

  SD1("sauver une connaissance détenue par des brigands"),
  SD2("récupérer une de ses possessions volée par des malandrins"),
  SD3("escorter une caravane d'une ville à l'autre"),
  SD4("débarasser la région d'une Liche qui terrorise la population"),
  SD5("débarasser la région d'un groupe de bandits qui terrorisent la population"),
  SD6("récupérer un objet magique de grande valeur (bien protégé)"),
  SD7("trouver le nécromancien responsable de l'apparition de zombies dans la région et de mettre fin à ses agissements"),
  SD8("trouver le coupable des nombreux vols commis dans le village ces derniers jours et de le rendre à la justice"),
  SD9("liquider une personne bien gardée"),
  SD10("trouver le véritable coupable d'un crime dont une personne est accusée à tort");

  private final String sentence;

  EScenarioQuest(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
