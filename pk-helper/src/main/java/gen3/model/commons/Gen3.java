package gen3.model.commons;

import commons.model.commons.Gen;
import org.jetbrains.annotations.Contract;

/**
 * Created by Germain on 02/04/2017.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class Gen3 extends Gen {

  private static final Gen3 INSTANCE = new Gen3();

  @Contract(pure = true)
  public static Gen3 getInstance() {
    return INSTANCE;
  }

  private Gen3() {
    super(3, "III");
  }
}
