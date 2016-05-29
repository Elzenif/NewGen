package mvc.model.dice;

/**
 * Created by Germain on 28/05/2016.
 */
public class DiceResult {

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

  public String getResult() {
    return result;
  }

  public EDiceResultType getEDiceResultType() {
    return eDiceResultType;
  }

  public EDiceTestResult getEDiceTestResult() {
    return eDiceTestResult;
  }
}
