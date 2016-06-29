package nbk.model.entity.enums;

import nbk.model.entity.utils.fields.HasNbHands;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 28/06/2016.
 */
public enum ENbHands implements HasNbHands {

  ONE(1) {
    @Override
    public String getPlural() {
      return "";
    }
  },
  TWO(2) {
    @Override
    public String getPlural() {
      return "s";
    }
  };

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
}
