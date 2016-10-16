package nbk.model.map.dungeon.constraints;

import java.util.stream.IntStream;

/**
 * Created by Germain on 02/10/2016.
 */
public class EDungeonTileSizes {

  public static Object[] values() {
    return IntStream.rangeClosed(5, 15).boxed().toArray();
  }
}
