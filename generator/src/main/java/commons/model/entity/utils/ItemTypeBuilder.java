package commons.model.entity.utils;

import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public interface ItemTypeBuilder extends HasRarity {

  ItemTypeBuilder setNames(Object first, Object... others);

  ItemTypeBuilder uncommon();

  ItemTypeBuilder rare();

  ItemTypeBuilder epic();

  ItemTypeBuilder legendary();

  List getNames();
}
