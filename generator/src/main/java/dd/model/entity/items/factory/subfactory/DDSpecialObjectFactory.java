package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDSpecialObject;

/**
 * Created by Germain on 30/10/2016.
 */
public class DDSpecialObjectFactory extends DDOneRarityTreasureSubFactory {

  private static final DDSpecialObjectFactory INSTANCE = new DDSpecialObjectFactory();

  private DDSpecialObjectFactory() {
  }

  public static DDSpecialObjectFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDSpecialObject.values();
  }
}
