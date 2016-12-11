package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDEquipment;

/**
 * Created by Germain on 11/12/2016.
 */
public class DDEquipmentFactory extends DDOneRarityTreasureSubFactory {

  private static final DDEquipmentFactory INSTANCE = new DDEquipmentFactory();

  private DDEquipmentFactory() {
  }

  public static DDEquipmentFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDEquipment.values();
  }
}
