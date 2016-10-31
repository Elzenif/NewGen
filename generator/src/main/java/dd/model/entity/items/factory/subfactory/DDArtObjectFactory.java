package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDArtObject;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDArtObjectFactory extends DDOneRarityTreasureSubFactory {

  private static final DDArtObjectFactory INSTANCE = new DDArtObjectFactory();

  private DDArtObjectFactory() {
  }

  public static DDArtObjectFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDArtObject.values();
  }
}
