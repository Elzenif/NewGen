package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDItemType;
import dd.model.entity.items.treasure.enums.EDDArtObject;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDArtObjectFactory extends DDTreasureSubFactory {

  private static final DDArtObjectFactory INSTANCE = new DDArtObjectFactory();

  private DDArtObjectFactory() {
  }

  public static DDArtObjectFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDItemType[] getValues() {
    return EDDArtObject.values();
  }
}
