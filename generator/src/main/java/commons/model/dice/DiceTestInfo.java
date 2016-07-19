package commons.model.dice;

import commons.utils.EOperator;

/**
 * Created by Germain on 25/06/2016.
 */
public class DiceTestInfo {

  private final boolean test;
  private final EOperator operator;
  private final int valueToTest;

  public DiceTestInfo(boolean test, EOperator operator, int valueToTest) {
    this.test = test;
    this.operator = operator;
    this.valueToTest = valueToTest;
  }

  public boolean isTest() {
    return test;
  }

  public EOperator getOperator() {
    return operator;
  }

  public int getValueToTest() {
    return valueToTest;
  }
}
