package generator.controller;

import commons.utils.MathUtils;

/**
 * Created by Germain on 25/06/2017.
 */

public abstract class AbstractController {

  protected int roll100() {
    return MathUtils.random(1, 100);
  }

}
