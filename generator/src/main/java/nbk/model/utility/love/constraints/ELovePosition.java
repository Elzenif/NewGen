package nbk.model.utility.love.constraints;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELovePosition implements ILoveDrawResult {
  LD1("efficace du molosse hardi", ELoveScore.GREAT),
  LD2("de la tourlousine siamoise", ELoveScore.GREAT),
  LD3("connue des musardins", ELoveScore.GOOD),
  LD4("du fricotage inversé", ELoveScore.GOOD),
  LD5("du petit lapin de Chnafon", ELoveScore.GOOD),
  LD6("de la brouette sudiste", ELoveScore.GOOD),
  LD7("issue d'un parchemin douteux", ELoveScore.GOOD),
  LD8("des éclairés de Lafoune", ELoveScore.GOOD),
  LD9("scabreuse du culte de Slanoush", ELoveScore.GOOD),
  LD10("bizarre mais fonctionnelle du héron", ELoveScore.GOOD),
  LD11("du brigand agile", ELoveScore.GOOD),
  LD12("la plus classique", ELoveScore.NEUTRAL),
  LD13("la plus acrobatique", ELoveScore.NEUTRAL),
  LD14("la plus incongrue", ELoveScore.NEUTRAL),
  LD15("controversée du flatamoule", ELoveScore.NEUTRAL),
  LD16("sans originalité du clabaudeur", ELoveScore.NEUTRAL),
  LD17("du baltringue maladroit", ELoveScore.BAD),
  LD18("du novice incompris", ELoveScore.AWFUL),
  LD19("du chantouillard féroce", ELoveScore.AWFUL),
  LD20("la plus désastreuse", ELoveScore.AWFUL)
  ;

  private final String sentence;
  private final ELoveScore loveScore;

  ELovePosition(String sentence, ELoveScore loveScore) {
    this.sentence = sentence;
    this.loveScore = loveScore;
  }

  @Override
  public String getSentence() {
    return sentence;
  }

  @Override
  public ELoveScore getLoveScore() {
    return loveScore;
  }
}
