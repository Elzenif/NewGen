package commons.controller.commons.results;

import commons.view.commons.results.ScrollableLabel;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Germain on 15/10/2016.
 */
public class ScrollableLabelMouseMotionListener extends MouseMotionAdapter {

  private final ScrollableLabel scrollableLabel;

  public ScrollableLabelMouseMotionListener(ScrollableLabel scrollableLabel) {
    this.scrollableLabel = scrollableLabel;

    scrollableLabel.setAutoscrolls(true);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
    scrollableLabel.scrollRectToVisible(rectangle);
  }
}
