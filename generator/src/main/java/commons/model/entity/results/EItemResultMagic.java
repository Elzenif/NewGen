package commons.model.entity.results;

import commons.model.entity.characteristics.primary.enums.EMagic;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 25/06/2016.
 */
enum EItemResultMagic {

  NOP(EMagic.NOPE, Font.PLAIN),
  MAG(EMagic.MAGIC, Font.BOLD),
  REL(EMagic.RELIC, Font.BOLD);

  private final EMagic magic;
  private final int fontStyle;

  EItemResultMagic(EMagic magic, int fontStyle) {
    this.magic = magic;
    this.fontStyle = fontStyle;
  }

  public EMagic getMagic() {
    return magic;
  }

  public int getFontStyle() {
    return fontStyle;
  }

  private static final Map<EMagic, Integer> MAP = new HashMap<>(
          Stream.of(EItemResultMagic.values())
                  .collect(Collectors.toMap(EItemResultMagic::getMagic, EItemResultMagic::getFontStyle))
  );

  public static int getItemResultFontStyle(EMagic magic) {
    return MAP.get(magic);
  }
}
