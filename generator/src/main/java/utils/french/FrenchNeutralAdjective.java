package utils.french;

/**
 * Created by Germain on 16/06/2016.
 */
public class FrenchNeutralAdjective implements FrenchAdjective {

  private final String neutralForm;

  public FrenchNeutralAdjective(String neutralForm) {
    this.neutralForm = neutralForm;
  }

  @Override
  public String getCorrectForm(Gender gender) {
    return neutralForm;
  }
}
