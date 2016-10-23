package commons.model.commons.constraints;

/**
 * Created by Germain on 23/10/2016.
 */
public class GenerationConstraints {

  private PredicateConstraints predicateConstraints;
  private DrawKeyConstraint drawKeyConstraint;
  private MapConstraint mapConstraint;

  public PredicateConstraints getPredicateConstraints() {
    if (predicateConstraints == null) {
      predicateConstraints = new PredicateConstraints();
    }
    return predicateConstraints;
  }

  public DrawKeyConstraint getDrawKeyConstraint() {
    if (drawKeyConstraint == null) {
      drawKeyConstraint = new DrawKeyConstraint();
    }
    return drawKeyConstraint;
  }

  public MapConstraint getMapConstraint() {
    if (mapConstraint == null) {
      mapConstraint = new MapConstraint();
    }
    return mapConstraint;
  }
}
