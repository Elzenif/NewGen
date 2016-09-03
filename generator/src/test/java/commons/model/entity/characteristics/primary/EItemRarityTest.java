package commons.model.entity.characteristics.primary;

import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.utils.EOperator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Germain on 06/06/2016.
 */
public class EItemRarityTest {

  @Test
  public void testOrderRarity() {
    assertThat(EOperator.LT.apply(EItemRarity.COMMON, EItemRarity.UNCOMMON)).isTrue();
    assertThat(EOperator.LT.apply(EItemRarity.UNCOMMON, EItemRarity.RARE)).isTrue();
    assertThat(EOperator.LT.apply(EItemRarity.RARE, EItemRarity.EPIC)).isTrue();
    assertThat(EOperator.LT.apply(EItemRarity.EPIC, EItemRarity.LEGENDARY)).isTrue();
  }
}
