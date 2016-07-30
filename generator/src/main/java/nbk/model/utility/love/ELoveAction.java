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
public enum ELoveAction implements ILoveDraw {
  LD1("caresse habilement", GREAT),
  LD2("titille avec adresse", GREAT),
  LD3("tripote doucement", GOOD),
  LD4("trifouille finement", GOOD),
  LD5("masse adroitement", GOOD),
  LD6("frotte comme il faut", GOOD),
  LD7("touche lentement", GOOD),
  LD8("caresse", GOOD),
  LD9("masturbe habilement", GOOD),
  LD10("courtise", GOOD),
  LD11("effleure gentiment", GOOD),
  LD12("mirlifoute", GOOD),
  LD13("palpe mollement", NEUTRAL),
  LD14("pétrit vigoureusement", NEUTRAL),
  LD15("tapote un peu vite", NEUTRAL),
  LD16("malaxe sauvagement", NEUTRAL),
  LD17("chatouille", BAD),
  LD18("radidoche", BAD),
  LD19("bourrine", AWFUL),
  LD20("maltraite", AWFUL)
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
