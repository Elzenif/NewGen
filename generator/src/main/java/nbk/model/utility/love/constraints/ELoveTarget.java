package nbk.model.utility.love.constraints;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELoveTarget implements ILoveDrawResult {
  LD1("la poitrine", ELoveScore.GREAT),
  LD2("les parties intimes", ELoveScore.GREAT),
  LD3("la bouche", ELoveScore.GREAT),
  LD4("la main", ELoveScore.GOOD),
  LD5("le bas du ventre", ELoveScore.GOOD),
  LD6("les fesses", ELoveScore.GOOD),
  LD7("les deux cuisses", ELoveScore.GOOD),
  LD8("la cuisse", ELoveScore.GOOD),
  LD9("un orifice", ELoveScore.GOOD),
  LD10("l'oreille droite", ELoveScore.GOOD),
  LD11("les deux mains", ELoveScore.NEUTRAL),
  LD12("le dos", ELoveScore.NEUTRAL),
  LD13("le slip", ELoveScore.NEUTRAL),
  LD14("le nez", ELoveScore.NEUTRAL),
  LD15("le genou", ELoveScore.NEUTRAL),
  LD16("les côtes", ELoveScore.NEUTRAL),
  LD17("le coude", ELoveScore.BAD),
  LD18("le pied gauche", ELoveScore.BAD),
  LD19("la récente plaie", ELoveScore.AWFUL),
  LD20("à côté", ELoveScore.AWFUL)
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
