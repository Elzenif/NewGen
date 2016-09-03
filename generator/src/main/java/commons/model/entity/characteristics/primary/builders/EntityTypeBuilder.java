package commons.model.entity.characteristics.primary.builders;

import commons.model.entity.characteristics.primary.fields.HasRarity;

import java.util.List;

/**
 * Created by Germain on 29/08/2016.
 */
public interface EntityTypeBuilder extends HasRarity {

  EntityTypeBuilder setNames(Object first, Object... others);

  EntityTypeBuilder common();

  EntityTypeBuilder uncommon();

  EntityTypeBuilder rare();
  
  List getNames();

}
