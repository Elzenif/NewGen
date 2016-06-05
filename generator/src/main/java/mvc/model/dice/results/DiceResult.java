package mvc.model.dice.results;

import mvc.model.commons.Result;
import mvc.model.dice.results.enums.EDiceResultType;
import mvc.model.dice.results.enums.EDiceTestResult;

/**
 * Created by Germain on 28/05/2016.
 */
public class DiceResult implements Result {

  private final String result;
  private final EDiceResultType eDiceResultType;
  private final EDiceTestResult eDiceTestResult;

  public DiceResult(String result, EDiceResultType eDiceResultType, EDiceTestResult eDiceTestResult) {
    this.result = result;
    this.eDiceResultType = eDiceResultType;
    this.eDiceTestResult = eDiceTestResult;
  }

  public DiceResult(String result) {
    this(result, EDiceResultType.NORMAL, EDiceTestResult.NO_TEST);
  }

  @Override
  public String getRawResult() {
    return result;
  }

  public EDiceResultType getEDiceResultType() {
    return eDiceResultType;
  }

  public EDiceTestResult getEDiceTestResult() {
    return eDiceTestResult;
  }
}
