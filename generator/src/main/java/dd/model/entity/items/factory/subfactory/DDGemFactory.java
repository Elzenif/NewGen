package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDItemType;
import dd.model.entity.items.treasure.enums.EDDGem;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDGemFactory extends DDTreasureSubFactory {

  private static final DDGemFactory INSTANCE = new DDGemFactory();

  private DDGemFactory() {
  }

  public static DDGemFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDItemType[] getValues() {
    return EDDGem.values();
  }
}
