package nbk.model.entity.items;

import commons.model.entity.constraints.GlobalConstraints;
import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.items.Item;
import commons.model.entity.utils.ItemUtils;
import commons.utils.SPositive;
import commons.utils.exception.NoAvailableItemTypeException;
import nbk.model.entity.enums.ENbkPredefinedArmor;
import nbk.model.entity.game.NbkGame;

import java.util.function.Predicate;

/**
 * Created by Germain on 26/06/2016.
 */
public class NbkPredefinedArmor extends Item<NbkGame> {

  private final ENbkPredefinedArmor predefinedArmor;

  public static NbkPredefinedArmor create(GlobalConstraints globalConstraints, ERarity rarity)
          throws NoAvailableItemTypeException {
    return new NbkPredefinedArmorBuilder(globalConstraints, rarity).build();
  }

  private NbkPredefinedArmor(NbkPredefinedArmorBuilder builder) {
    super(builder);
    predefinedArmor = builder.predefinedArmor;
  }

  @Override
  public String toString() {
    return predefinedArmor.getName();
  }

  private static class NbkPredefinedArmorBuilder extends ItemBuilder {

    ENbkPredefinedArmor predefinedArmor;

    NbkPredefinedArmorBuilder(GlobalConstraints globalConstraints, ERarity rarity) throws NoAvailableItemTypeException {
      super(rarity);
      setPredefinedArmor(globalConstraints.getPredicate(ENbkPredefinedArmor.class), rarity);
    }

    void setPredefinedArmor(Predicate<ENbkPredefinedArmor> armorPredicate, ERarity rarity)
            throws NoAvailableItemTypeException {
      predefinedArmor = ItemUtils.selectRandomRarity(ENbkPredefinedArmor.values(), armorPredicate, rarity);
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
