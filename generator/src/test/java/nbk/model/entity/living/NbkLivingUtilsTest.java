package nbk.model.entity.living;

import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Germain on 29/08/2016.
 */
public class NbkLivingUtilsTest {

  @Test
  public void humanShouldAlwaysBeAnAvailableOrigin() {
    assertTrue(NbkLivingUtils.listAvailableOrigins().contains(ENbkOrigin.HUMAN));
  }

}