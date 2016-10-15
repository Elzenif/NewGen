package commons.view.commons.results;

import org.junit.Before;
import org.junit.Test;

import javax.swing.SwingConstants;
import java.awt.Rectangle;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 12/10/2016.
 */
public class ScrollableLabelTest {

  private ScrollableLabel scrollableLabel;

  @Before
  public void setUp() throws Exception {
    scrollableLabel = new ScrollableLabel();
  }

  @Test
  public void getPreferredScrollableViewportSizeShouldReturnGetPreferredSize() {
    assertThat(scrollableLabel.getPreferredScrollableViewportSize())
        .isNotNull()
        .isEqualTo(scrollableLabel.getPreferredSize());
  }

  @Test
  public void shouldScrollRightHorizontallyBy1Pixel_WhenTileSizeIsNotDefined() {
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(), SwingConstants.HORIZONTAL, 1);
    assertThat(increment).isEqualTo(1);
  }

  @Test
  public void shouldScrollLeftHorizontallyBy1Pixel_WhenTileSizeIsNotDefined() {
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(), SwingConstants.HORIZONTAL, -1);
    assertThat(increment).isEqualTo(1);
  }

  @Test
  public void shouldScrollDownVerticallyBy1Pixel_WhenTileSizeIsNotDefined() {
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(), SwingConstants.VERTICAL, 1);
    assertThat(increment).isEqualTo(1);
  }

  @Test
  public void shouldScrollUpVerticallyBy1Pixel_WhenTileSizeIsNotDefined() {
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(), SwingConstants.VERTICAL, -1);
    assertThat(increment).isEqualTo(1);
  }

  @Test
  public void shouldScrollRightHorizontallyByXPixels_WhenNotOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(13, 30, 20, 20),
        SwingConstants.HORIZONTAL, 1);
    assertThat(increment).isEqualTo(7);
  }

  @Test
  public void shouldScrollRightHorizontallyByXPixels_WhenOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(10, 37, 20, 20),
        SwingConstants.HORIZONTAL, 1);
    assertThat(increment).isEqualTo(10);
  }

  @Test
  public void shouldScrollLeftHorizontallyByXPixels_WhenNotOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(13, 30, 20, 20),
        SwingConstants.HORIZONTAL, -1);
    assertThat(increment).isEqualTo(3);
  }

  @Test
  public void shouldScrollLeftHorizontallyByXPixels_WhenOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(10, 37, 20, 20),
        SwingConstants.HORIZONTAL, -1);
    assertThat(increment).isEqualTo(10);
  }

  @Test
  public void shouldScrollDownVerticallyByXPixels_WhenNotOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(10, 37, 20, 20),
        SwingConstants.VERTICAL, 1);
    assertThat(increment).isEqualTo(3);
  }

  @Test
  public void shouldScrollDownVerticallyByXPixels_WhenOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(13, 30, 20, 20),
        SwingConstants.VERTICAL, 1);
    assertThat(increment).isEqualTo(10);
  }

  @Test
  public void shouldScrollUpVerticallyByXPixels_WhenNotOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(10, 37, 20, 20),
        SwingConstants.VERTICAL, -1);
    assertThat(increment).isEqualTo(7);
  }

  @Test
  public void shouldScrollUpVerticallyByXPixels_WhenOnATileBorder() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableUnitIncrement(new Rectangle(13, 30, 20, 20),
        SwingConstants.VERTICAL, -1);
    assertThat(increment).isEqualTo(10);
  }

  @Test
  public void shouldScrollHorizontallyByXPixels_WhenClickOnScrollBar() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableBlockIncrement(new Rectangle(25, 47), SwingConstants.HORIZONTAL, 0);
    assertThat(increment).isEqualTo(15);
  }

  @Test
  public void shouldScrollVerticallyByXPixels_WhenClickOnScrollBar() {
    scrollableLabel.setMaxUnitIncrement(10);
    int increment = scrollableLabel.getScrollableBlockIncrement(new Rectangle(25, 47), SwingConstants.VERTICAL, 0);
    assertThat(increment).isEqualTo(37);
  }

}
