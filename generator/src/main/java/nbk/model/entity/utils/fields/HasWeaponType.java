package nbk.model.entity.utils.fields;

import nbk.model.entity.enums.ENbkWeaponType;

/**
 * Created by Germain on 29/06/2016.
 */
@FunctionalInterface
public interface HasWeaponType {

  ENbkWeaponType getWeaponType();
}
