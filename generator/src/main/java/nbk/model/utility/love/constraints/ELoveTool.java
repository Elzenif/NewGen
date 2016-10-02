package nbk.model.utility.love.constraints;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELoveTool implements ILoveDrawResult {
  LD1("son sexe", ELoveScore.GREAT),
  LD2("deux doigts", ELoveScore.GREAT),
  LD3("un doigt", ELoveScore.GOOD),
  LD4("sa bouche", ELoveScore.GOOD),
  LD5("son nez", ELoveScore.GOOD),
  LD6("un objet oblong", ELoveScore.GOOD),
  LD7("sa poitrine", ELoveScore.GOOD),
  LD8("trois doigts", ELoveScore.GOOD),
  LD9("une bougie allumée", ELoveScore.GOOD),
  LD10("sa main", ELoveScore.GOOD),
  LD11("ses deux mains", ELoveScore.NEUTRAL),
  LD12("quatre doigts", ELoveScore.NEUTRAL),
  LD13("ses cheveux", ELoveScore.NEUTRAL),
  LD14("un genre de fouet", ELoveScore.NEUTRAL),
  LD15("un truc magique", ELoveScore.NEUTRAL),
  LD16("son coude", ELoveScore.NEUTRAL),
  LD17("son poing", ELoveScore.NEUTRAL),
  LD18("sa gourde", ELoveScore.BAD),
  LD19("un chiffon sale", ELoveScore.AWFUL),
  LD20("un vieux saucisson", ELoveScore.AWFUL)
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
