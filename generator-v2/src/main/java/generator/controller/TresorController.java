package generator.controller;

import commons.utils.Pair;
import generator.model.entity.TresorType;
import generator.utils.GeneratorUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 27/05/2017.
 */
@Service
public class TresorController {

  public String convertTresor(TresorType tresorType, @NotNull String detail) {
    Pair<Integer, String> pair = GeneratorUtils.getMultiplier(detail);
    Integer multiplier = pair.getLeft();
    String detailsRight = pair.getRight();
    switch (tresorType) {
      case pieces:
        String[] split = detailsRight.split("p(?=\\w)");
        if (split.length != 2) {
          throw new IllegalArgumentException("Error when parsing pieces");
        }
        int score = multiplier * Integer.valueOf(split[0]);
        return score + "p" + split[1];
      case biens:
        break;
      case objets:
      default:
        break;
    }
    return detail + " " + tresorType;
  }

}
