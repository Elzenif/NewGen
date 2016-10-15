package commons.view.map.results;

import commons.view.commons.results.Result;

import java.awt.Image;

/**
 * Created by Germain on 15/10/2016.
 */
public interface MapResult extends Result<Image> {

  int getTileSize();
}
