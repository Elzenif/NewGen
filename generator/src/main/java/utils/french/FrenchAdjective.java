package utils.french;

/**
 * Created by Germain on 16/06/2016.
 */
@FunctionalInterface
public interface FrenchAdjective extends FrenchString {

  String getCorrectForm(Gender gender);
}
