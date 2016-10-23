package nbk.model.entity.items.characteristics.primary.enums;

import commons.model.commons.constraints.intf.GenericPredicateConstraint;
import commons.model.entity.characteristics.primary.Primary;
import nbk.model.entity.items.characteristics.primary.fields.HasNbHands;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;

import java.util.function.Predicate;

/**
 * Created by Germain on 28/06/2016.
 */
public enum ENbHands implements Primary, HasNbHands, GenericPredicateConstraint<ENbHands> {

  ONE(1) {
    @Override
    public String getPlural() {
      return "";
    }
  },
  TWO(2) {
    @Override
    public String getPlural() {
      return S;
    }
  };

  @NonNls
  private static final String S = "s";
  private final int nb;

  ENbHands(int nb) {
    this.nb = nb;
  }

  @Contract(pure = true)
  @Override
  public ENbHands getNbHands() {
    return this;
  }

  public int getNb() {
    return nb;
  }

  public abstract String getPlural();

  @Override
  public Predicate<ENbHands> getPredicate() {
    return e -> e.getNbHands() == this;
  }
}
