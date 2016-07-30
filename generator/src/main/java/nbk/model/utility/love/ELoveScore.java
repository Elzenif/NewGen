package nbk.model.utility.love;

/**
 * Created by Germain on 24/07/2016.
 */
public enum ELoveScore {

  GREAT(2),
  GOOD(1),
  NEUTRAL(0),
  BAD(-1),
  AWFUL(-2)
  ;


  private final int score;

  ELoveScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }
}
