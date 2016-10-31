package dd.model.entity.items.factory.subfactory;

/**
 * Created by Germain on 29/10/2016.
 */
public abstract class DDTreasureSubFactory {

  protected int nb = 1;

  public void setNumberToGenerate(int nb) {
    this.nb = nb;
  }
}
