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
public enum ELoveTool implements ILoveDraw {
  LD1("son sexe", GREAT),
  LD2("deux doigts", GREAT),
  LD3("un doigt", GOOD),
  LD4("sa bouche", GOOD),
  LD5("son nez", GOOD),
  LD6("un objet oblong", GOOD),
  LD7("sa poitrine", GOOD),
  LD8("trois doigts", GOOD),
  LD9("une bougie allumée", GOOD),
  LD10("sa main", GOOD),
  LD11("ses deux mains", NEUTRAL),
  LD12("quatre doigts", NEUTRAL),
  LD13("ses cheveux", NEUTRAL),
  LD14("un genre de fouet", NEUTRAL),
  LD15("un truc magique", NEUTRAL),
  LD16("son coude", NEUTRAL),
  LD17("son poing", NEUTRAL),
  LD18("sa gourde", BAD),
  LD19("un chiffon sale", AWFUL),
  LD20("un vieux saucisson", AWFUL)
  ;

  private final String sentence;
  private final ELoveScore loveScore;

  ELoveTool(String sentence, ELoveScore loveScore) {
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
