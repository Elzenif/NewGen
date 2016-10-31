package commons.model.entity.utils;

import commons.model.entity.characteristics.primary.CustomRarity;
import commons.model.entity.characteristics.primary.fields.HasMultipleRarities;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.model.entity.characteristics.primary.fields.IRarityKey;
import commons.utils.exception.NoAvailableEntityTypeException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 20/07/2016.
 */
public class EntityUtilsTest {

  @Test
  public void resultShouldBeOKWithoutConstraint() throws NoAvailableEntityTypeException {
    RarityTestEnum result;
    for (int i = 0; i < 10; i++) {
      result = EntityUtils.selectRandomRarity(RarityTestEnum.values(), p -> true);
      assertThat(RarityTestEnum.values()).contains(result);
    }
  }

  @Test
  public void resultShouldBeOKWithConstraint() throws NoAvailableEntityTypeException {
    RarityTestEnum result;
    for (int i = 0; i < 10; i++) {
      result = EntityUtils.selectRandomRarity(RarityTestEnum.values(), p -> p.getRarity().getProba() < 2);
      assertThat(result).isEqualTo(RarityTestEnum.R1);
    }
  }

  @Test
  public void resultShouldBeOKWithCustomRarityMethod() throws NoAvailableEntityTypeException {
    CustomRarityTestEnum result;
    for (int i = 0; i < 10; i++) {
      result = EntityUtils.selectRandomWithCustomRarity(CustomRarityTestEnum.values(), CustomRarityKeyEnum.K1);
      assertThat(CustomRarityTestEnum.values()).contains(result);
    }
    for (int i = 0; i < 10; i++) {
      result = EntityUtils.selectRandomWithCustomRarity(CustomRarityTestEnum.values(), CustomRarityKeyEnum.K2);
      assertThat(result).isEqualTo(CustomRarityTestEnum.CR1);
    }
  }

  private enum RarityTestEnum implements HasRarity {

    R1(1),
    R2(2),
    R3(3);

    private final int proba;

    RarityTestEnum(int proba) {
      this.proba = proba;
    }

    @Override
    public CustomRarity getRarity() {
      return new CustomRarity(proba);
    }
  }


  private enum CustomRarityTestEnum implements HasMultipleRarities<CustomRarityKeyEnum> {

    CR1(1, 2),
    CR2(1, 0);

    private final Map<CustomRarityKeyEnum, HasRarity> map = new HashMap<>();

    CustomRarityTestEnum(int proba1, int proba2) {
      map.put(CustomRarityKeyEnum.K1, new CustomRarity(proba1));
      map.put(CustomRarityKeyEnum.K2, new CustomRarity(proba2));
    }

    @Override
    public Map<CustomRarityKeyEnum, HasRarity> getRarities() {
      return map;
    }
  }

  private enum CustomRarityKeyEnum implements IRarityKey {
    K1, K2
  }
}
