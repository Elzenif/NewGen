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
public enum ELoveTarget implements ILoveDrawResult {
  LD1("la poitrine", GREAT),
  LD2("les parties intimes", GREAT),
  LD3("la bouche", GREAT),
  LD4("la main", GOOD),
  LD5("le bas du ventre", GOOD),
  LD6("les fesses", GOOD),
  LD7("les deux cuisses", GOOD),
  LD8("la cuisse", GOOD),
  LD9("un orifice", GOOD),
  LD10("l'oreille droite", GOOD),
  LD11("les deux mains", NEUTRAL),
  LD12("le dos", NEUTRAL),
  LD13("le slip", NEUTRAL),
  LD14("le nez", NEUTRAL),
  LD15("le genou", NEUTRAL),
  LD16("les côtes", NEUTRAL),
  LD17("le coude", BAD),
  LD18("le pied gauche", BAD),
  LD19("la récente plaie", AWFUL),
  LD20("à côté", AWFUL)
  ;

  private final String sentence;
  private final ELoveScore loveScore;

  ELoveTarget(String sentence, ELoveScore loveScore) {
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
