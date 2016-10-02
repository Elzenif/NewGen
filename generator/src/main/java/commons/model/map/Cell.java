package commons.model.map;

import java.awt.Rectangle;

/**
 * Created by Germain on 29/09/2016.
 */
public class Cell extends Rectangle {

  private EMapPart mapPart = EMapPart.WALL;

  public Cell(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public EMapPart getMapPart() {
    return mapPart;
  }

  public void setMapPart(EMapPart mapPart) {
    this.mapPart = mapPart;
  }
}
