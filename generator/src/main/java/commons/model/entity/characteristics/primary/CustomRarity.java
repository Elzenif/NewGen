package commons.model.entity.characteristics.primary;

import commons.model.entity.characteristics.primary.enums.IRarity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 29/10/2016.
 */
public class CustomRarity implements IRarity<CustomRarity> {

  private final int proba;

  public CustomRarity(int proba) {
    this.proba = proba;
  }

  @Override
  public CustomRarity getRarity() {
    return this;
  }

  @Override
  public Predicate<CustomRarity> getPredicate() {
    return p -> true;
  }

  @Override
  public int getProba() {
    return proba;
  }

  @Override
  public int compareTo(@NotNull CustomRarity o) {
    return Integer.valueOf(proba).compareTo(o.getProba());
  }
}
