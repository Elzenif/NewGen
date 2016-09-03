package commons.model.entity.characteristics.primary.enums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Created by Germain on 29/08/2016.
 */
public enum EGeneralRarity implements IRarity<EGeneralRarity> {
  COMMON(54),
  UNCOMMON(31),
  RARE(15);

  private final int proba;

  EGeneralRarity(int proba) {
    this.proba = proba;
  }

  @Contract(pure = true)
  @Override
  public EGeneralRarity getRarity() {
    return this;
  }

  @NotNull
  @Override
  public Predicate<EGeneralRarity> getPredicate() {
    return p -> p.ordinal() >= ordinal();
  }

  @Override
  public int getProba() {
    return proba;
  }
}
