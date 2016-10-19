package commons.utils.french;

/**
 * Created by Germain on 16/06/2016.
 */
public class FrenchGenderAdjective implements FrenchAdjective {

  private final String masculineForm;
  private final String feminineForm;

  public FrenchGenderAdjective(String masculineForm, String feminineForm) {
    this.masculineForm = masculineForm;
    this.feminineForm = feminineForm;
  }

  @Override
  public String getCorrectForm(Gender gender) {
    return gender == Gender.MASCULINE || gender == Gender.NEUTRAL
        ? masculineForm
        : feminineForm;
  }
}
