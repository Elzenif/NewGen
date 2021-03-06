package nbk.model.entity.items;

import commons.model.commons.constraints.GenerationConstraints;
import commons.model.commons.constraints.PredicateConstraints;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.utils.EOperator;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.commons.characteristics.primary.enums.ESize;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.primary.enums.EWeight;
import nbk.model.entity.items.characteristics.secondary.enums.ENbkPredefinedArmor;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 28/06/2016.
 */
public class NbkPredefinedArmorTest {

  private PredicateConstraints predicateConstraints;
  private NbkPredefinedArmor armor;

  @Before
  public void init() {
    predicateConstraints = new GenerationConstraints().getPredicateConstraints();
  }

  @Test
  public void testArmorIsNotNull() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    assertThat(armor).isNotNull();
  }

  @Test
  public void testPredefinedArmorIsNotNull() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    assertThat(armor.getPredefinedArmor()).isNotNull();
  }

  @Test
  public void testPredefinedArmorIsValid() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    Set<ENbkPredefinedArmor> armorTypes = EnumSet.allOf(ENbkPredefinedArmor.class);
    assertThat(armorTypes).contains(armor.getPredefinedArmor());
  }

  @Test
  public void testToStringIsValid() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    assertThat(armor.toString().contains("@")).isFalse();
  }

  @Test
  public void testSizeIsValid() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    Set<ESize> sizeSet = EnumSet.allOf(ESize.class);
    assertThat(sizeSet).contains(armor.getSize());
  }

  @Test
  public void testWeightIsValid() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    Set<EWeight> weightSet = EnumSet.allOf(EWeight.class);
    assertThat(weightSet).contains(armor.getWeight());
  }

  @Test
  public void testBodyPartIsValid() throws NoAvailableEntityTypeException {
    armor = NbkPredefinedArmor.create(predicateConstraints);
    Set<EBodyPart> bodyPartSet = EnumSet.allOf(EBodyPart.class);
    for (EBodyPart bodyPart : armor.getBodyParts())
      assertThat(bodyPartSet).contains(bodyPart);
  }

  @Test
  public void testCreateArmorWithRarityConstraint() throws NoAvailableEntityTypeException {
    for (EItemRarity rarity : EItemRarity.values()) {
      predicateConstraints.update(ENbkPredefinedArmor.getConstraints(), EItemRarity.class, rarity);
      armor = NbkPredefinedArmor.create(predicateConstraints);
      assertThat(armor).isNotNull();
      assertThat(EOperator.GTE.apply(armor.getRarity(), rarity)).isTrue();
      predicateConstraints.update(ENbkPredefinedArmor.getConstraints(), EItemRarity.class, rarity);
    }
  }
}