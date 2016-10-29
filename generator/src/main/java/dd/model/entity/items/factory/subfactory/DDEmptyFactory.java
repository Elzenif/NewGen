package dd.model.entity.items.factory.subfactory;

import dd.model.entity.items.characteristics.fields.DDItemType;
import dd.model.entity.items.treasure.DDTreasure;

import java.util.Collections;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
public class DDEmptyFactory extends DDTreasureSubFactory {

  private static final DDEmptyFactory INSTANCE = new DDEmptyFactory();

  private DDEmptyFactory() {
  }

  public static DDEmptyFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public List<DDTreasure> generate() {
    return Collections.emptyList();
  }

  @Override
  protected DDItemType[] getValues() {
    throw new UnsupportedOperationException("This method should not be called");
  }
}
