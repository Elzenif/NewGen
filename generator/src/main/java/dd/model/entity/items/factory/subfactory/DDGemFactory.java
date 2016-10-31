package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;
import dd.model.entity.items.treasures.enums.EDDGem;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDGemFactory extends DDOneRarityTreasureSubFactory {

  private static final DDGemFactory INSTANCE = new DDGemFactory();

  private DDGemFactory() {
  }

  public static DDGemFactory getInstance() {
    return INSTANCE;
  }

  @Override
  protected DDOneRarityItemType[] getValues() {
    return EDDGem.values();
  }
}
