package nbk.model.utility.love;

import static nbk.model.utility.love.ELoveScore.AWFUL;
import static nbk.model.utility.love.ELoveScore.BAD;
import static nbk.model.utility.love.ELoveScore.GOOD;
import static nbk.model.utility.love.ELoveScore.GREAT;
import static nbk.model.utility.love.ELoveScore.NEUTRAL;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELovePosition implements ILoveDrawResult {
  LD1("efficace du molosse hardi", GREAT),
  LD2("de la tourlousine siamoise", GREAT),
  LD3("connue des musardins", GOOD),
  LD4("du fricotage inversé", GOOD),
  LD5("du petit lapin de Chnafon", GOOD),
  LD6("de la brouette sudiste", GOOD),
  LD7("issue d'un parchemin douteux", GOOD),
  LD8("des éclairés de Lafoune", GOOD),
  LD9("scabreuse du culte de Slanoush", GOOD),
  LD10("bizarre mais fonctionnelle du héron", GOOD),
  LD11("du brigand agile", GOOD),
  LD12("la plus classique", NEUTRAL),
  LD13("la plus acrobatique", NEUTRAL),
  LD14("la plus incongrue", NEUTRAL),
  LD15("controversée du flatamoule", NEUTRAL),
  LD16("sans originalité du clabaudeur", NEUTRAL),
  LD17("du baltringue maladroit", BAD),
  LD18("du novice incompris", AWFUL),
  LD19("du chantouillard féroce", AWFUL),
  LD20("la plus désastreuse", AWFUL)
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
