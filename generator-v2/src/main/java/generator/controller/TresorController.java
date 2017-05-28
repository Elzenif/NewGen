package generator.controller;

import commons.model.dice.Dice;
import generator.model.entity.TresorType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 27/05/2017.
 */
@Service
public class TresorController {

  public String convertTresor(TresorType tresorType, @NotNull String detail) {
    switch (tresorType) {
      case pieces:
        String[] split = detail.split("[dxp](?=\\w)");
        if (split.length != 4) {
          throw new IllegalArgumentException("Error when parsing pieces");
        }
        Dice dice = new Dice(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        dice.roll();
        int result = dice.getScore() * Integer.valueOf(split[2]);
        return result + "p" + split[3];
      case biens:
        break;
      case objets:
      default:
        break;
    }
    return detail + " " + tresorType;
  }

}
