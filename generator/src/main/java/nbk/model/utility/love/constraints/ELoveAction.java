package nbk.model.utility.love.constraints;

/**
 * Created by Germain on 24/07/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ELoveAction implements ILoveDrawResult {
  LD1("caresse habilement", ELoveScore.GREAT),
  LD2("titille avec adresse", ELoveScore.GREAT),
  LD3("tripote doucement", ELoveScore.GOOD),
  LD4("trifouille finement", ELoveScore.GOOD),
  LD5("masse adroitement", ELoveScore.GOOD),
  LD6("frotte comme il faut", ELoveScore.GOOD),
  LD7("touche lentement", ELoveScore.GOOD),
  LD8("caresse", ELoveScore.GOOD),
  LD9("masturbe habilement", ELoveScore.GOOD),
  LD10("courtise", ELoveScore.GOOD),
  LD11("effleure gentiment", ELoveScore.GOOD),
  LD12("mirlifoute", ELoveScore.GOOD),
  LD13("palpe mollement", ELoveScore.NEUTRAL),
  LD14("pétrit vigoureusement", ELoveScore.NEUTRAL),
  LD15("tapote un peu vite", ELoveScore.NEUTRAL),
  LD16("malaxe sauvagement", ELoveScore.NEUTRAL),
  LD17("chatouille", ELoveScore.BAD),
  LD18("radidoche", ELoveScore.BAD),
  LD19("bourrine", ELoveScore.AWFUL),
  LD20("maltraite", ELoveScore.AWFUL)
  ;

  private final String sentence;
  private final ELoveScore loveScore;

  ELoveAction(String sentence, ELoveScore loveScore) {
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
