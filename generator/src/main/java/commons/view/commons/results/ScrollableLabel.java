package commons.view.commons.results;

import org.intellij.lang.annotations.MagicConstant;

import javax.swing.JLabel;
import javax.swing.Scrollable;
import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * Created by Germain on 12/10/2016.
 */
public class ScrollableLabel extends JLabel implements Scrollable {

  private int maxUnitIncrement = 1;

  public ScrollableLabel() {
    super();
  }

  @Override
  public Dimension getPreferredScrollableViewportSize() {
    return getPreferredSize();
  }

  @Override
  public int getScrollableUnitIncrement(Rectangle visibleRect,
                                        @MagicConstant(intValues = {HORIZONTAL, VERTICAL}) int orientation,
                                        int direction) {
    int currentPosition = (orientation == HORIZONTAL) ? visibleRect.x : visibleRect.y;
    if (direction < 0) {
      int diff = currentPosition - (currentPosition / maxUnitIncrement) * maxUnitIncrement;
      return (diff == 0) ? maxUnitIncrement : diff;
    } else {
      return ((currentPosition / maxUnitIncrement) + 1) * maxUnitIncrement - currentPosition;
    }
  }

  @Override
  public int getScrollableBlockIncrement(Rectangle visibleRect,
                                         @MagicConstant(intValues = {HORIZONTAL, VERTICAL}) int orientation,
                                         int direction) {
    int size = (orientation == HORIZONTAL) ? visibleRect.width : visibleRect.height;
    return size - maxUnitIncrement;
  }

  @Override
  public boolean getScrollableTracksViewportWidth() {
    return false;
  }

  @Override
  public boolean getScrollableTracksViewportHeight() {
    return false;
  }

  public void setMaxUnitIncrement(int maxUnitIncrement) {
    this.maxUnitIncrement = maxUnitIncrement;
  }
}
