package nbk.model.entity.items;

import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.items.Item;
import commons.model.entity.utils.ItemUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.commons.NbkGame;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.primary.enums.EWeight;
import nbk.model.entity.characteristics.primary.fields.HasSize;
import nbk.model.entity.characteristics.primary.fields.HasWeight;
import nbk.model.entity.characteristics.primary.fields.IsBodyPart;
import nbk.model.entity.characteristics.secondary.enums.ENbkPredefinedArmor;

import java.util.EnumSet;
import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkPredefinedArmor extends Item<NbkGame> implements HasWeight, IsBodyPart, HasSize {

  private final ENbkPredefinedArmor predefinedArmor;

  public static NbkPredefinedArmor create(GlobalConstraints globalConstraints)
          throws NoAvailableItemTypeException {
    return new NbkPredefinedArmorBuilder(globalConstraints).build();
  }

  private NbkPredefinedArmor(NbkPredefinedArmorBuilder builder) {
    super(builder);
    predefinedArmor = builder.predefinedArmor;
  }

  ENbkPredefinedArmor getPredefinedArmor() {
    return predefinedArmor;
  }

  @Override
  public String toString() {
    return predefinedArmor.getName();
  }

  @Override
  public ESize getSize() {
    return predefinedArmor.getSize();
  }

  @Override
  public EWeight getWeight() {
    return predefinedArmor.getWeight();
  }

  @Override
  public EnumSet<EBodyPart> getBodyParts() {
    return predefinedArmor.getBodyParts();
  }

  private static class NbkPredefinedArmorBuilder extends ItemBuilder {

    ENbkPredefinedArmor predefinedArmor;

    NbkPredefinedArmorBuilder(GlobalConstraints globalConstraints) throws NoAvailableItemTypeException {
      setPredefinedArmor(getPredicate(globalConstraints));
      rarity = predefinedArmor.getRarity();
    }

    Predicate<ENbkPredefinedArmor> getPredicate(GlobalConstraints globalConstraints) {
      return ENbkPredefinedArmor.getPredicate(globalConstraints);
    }

    void setPredefinedArmor(Predicate<ENbkPredefinedArmor> armorPredicate) throws NoAvailableItemTypeException {
      predefinedArmor = ItemUtils.selectRandomRarity(ENbkPredefinedArmor.values(), armorPredicate);
    }

    @Override
    public SPositive getQuantity() {
      return SPositive.ONE;
    }

    @Override
    public EMagic getMagic() {
      return predefinedArmor.getMagic();
    }

    @Override
    protected NbkPredefinedArmor build() {
      return new NbkPredefinedArmor(this);
    }

  }
}
