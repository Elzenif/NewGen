package nbk.model.entity.living;

import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 29/08/2016.
 */
public class NbkLivingUtilsTest {

  @Test
  public void humanShouldAlwaysBeAnAvailableOrigin() {
    assertThat(NbkLivingUtils.listAvailableOrigins()).contains(ENbkOrigin.HUMAN);
  }

}