package dd.model.entity.utils;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Germain on 18/12/2016.
 */
public enum EDDCoinType {
  PP, PO, PA, PC;


  @NotNull
  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
