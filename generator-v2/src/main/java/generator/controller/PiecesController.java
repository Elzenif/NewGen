package generator.controller;

import commons.utils.MathUtils;
import commons.utils.Pair;
import generator.utils.GeneratorUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Germain on 28/05/2017.
 */
@Service
public class PiecesController extends AbstractController {

  public String generate(String detail) {
    Pair<Integer, String> pair = GeneratorUtils.getMultiplier(detail);
    Integer multiplier = pair.getLeft();
    String detailsRight = pair.getRight();
    String[] split = detailsRight.split("p(?=\\w)");
    if (split.length != 2) {
      throw new IllegalArgumentException("Error when parsing pieces");
    }
    int score = multiplier * Integer.valueOf(split[0]);
    return score + "p" + split[1];
  }

  public String chooseRandomAndAddValue(String elements, String separator, String valueString) {
    String[] split = elements.split(separator);
    String name = MathUtils.chooseRandom(Arrays.asList(split));
    String value = generate(valueString);
    return name.toLowerCase() + " (" + value + ")";
  }

}
