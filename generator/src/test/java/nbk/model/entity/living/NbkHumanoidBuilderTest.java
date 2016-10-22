package nbk.model.entity.living;

import commons.model.entity.utils.EntityUtils;
import commons.utils.exception.NoAvailableEntityTypeException;
import nbk.model.entity.living.characteristics.secondary.enums.ENbkOrigin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * Created by Germain on 22/10/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EntityUtils.class)
public class NbkHumanoidBuilderTest {

  private NbkHumanoid humanoid;

  @Test
  public void humanoidWithSpecialOriginShouldNotHaveAProfession() throws Exception {
    PowerMockito.mockStatic(EntityUtils.class);
    try {
      for (ENbkOrigin origin : ENbkOrigin.values()) {
        if (!origin.getCanHaveProfession()) {
          PowerMockito.when(EntityUtils.selectRandomRarity(Matchers.any(ENbkOrigin[].class), Matchers.any()))
              .thenReturn(origin);
          humanoid = NbkHumanoid.create();
          assertThat(humanoid.getOrigin()).isEqualTo(origin);
          assertThat(humanoid.getProfession()).isNull();
        }
      }
    } catch (NoAvailableEntityTypeException e) {
      fail("Should not be called");
      e.printStackTrace();
    }
  }


}
