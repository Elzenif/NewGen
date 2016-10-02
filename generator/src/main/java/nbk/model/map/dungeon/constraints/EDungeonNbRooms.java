package nbk.model.map.dungeon.constraints;

import org.jetbrains.annotations.Contract;

import java.util.stream.IntStream;

/**
 * Created by Germain on 02/10/2016.
 */
public class EDungeonNbRooms {

  @Contract(" -> !null")
  public static Object[] values() {
    return IntStream.rangeClosed(2, 20).boxed().toArray();
  }
}
