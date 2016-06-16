package utils.french;

/**
 * Created by Germain on 16/06/2016.
 */
public class FrenchNoun implements FrenchString {

  private final Gender gender;
  private String noun;

  public FrenchNoun(Gender gender, String noun) {
    this.gender = gender;
    this.noun = noun;
  }

  public FrenchNoun(FrenchNoun frenchNoun) {
    this.gender = frenchNoun.getGender();
    this.noun = frenchNoun.getNoun();
  }

  public Gender getGender() {
    return gender;
  }

  private String getNoun() {
    return noun;
  }

  @Override
  public String toString() {
    return noun;
  }

  public void addString(String string) {
    noun += string;
  }

}
