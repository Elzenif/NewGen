package nbk.model.entity.items;

import commons.model.commons.constraints.PredicateConstraints;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.items.Item;
import commons.model.entity.utils.EntityUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.commons.characteristics.primary.enums.ESize;
import nbk.model.commons.characteristics.primary.fields.HasSize;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.primary.enums.EWeight;
import nbk.model.entity.items.characteristics.primary.fields.HasWeight;
import nbk.model.entity.items.characteristics.primary.fields.IsBodyPart;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedArmor;

import java.util.EnumSet;
import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkPredefinedArmor extends Item implements HasWeight, IsBodyPart, HasSize {

  private final ENbkPredefinedArmor predefinedArmor;

  private NbkPredefinedArmor(NbkPredefinedArmorBuilder builder) {
    super(builder);
    predefinedArmor = builder.predefinedArmor;
  }

  public static NbkPredefinedArmor create(PredicateConstraints predicateConstraints)
      throws NoAvailableEntityTypeException {
    return new NbkPredefinedArmorBuilder(predicateConstraints).build();
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

    NbkPredefinedArmorBuilder(PredicateConstraints predicateConstraints) throws NoAvailableEntityTypeException {
      setPredefinedArmor(getPredicate(predicateConstraints));
      rarity = predefinedArmor.getRarity();
    }

    Predicate<ENbkPredefinedArmor> getPredicate(PredicateConstraints predicateConstraints) {
      return ENbkPredefinedArmor.getPredicate(predicateConstraints);
    }

    void setPredefinedArmor(Predicate<ENbkPredefinedArmor> armorPredicate) throws NoAvailableEntityTypeException {
      predefinedArmor = EntityUtils.selectRandomRarity(ENbkPredefinedArmor.values(), armorPredicate);
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
