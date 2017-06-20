package commons.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

  @Test
  public void removePatternAtEndOfString1() {
    String result = StringUtils.removePatternAtEndOfString("a b c (d e f)", "( )?\\(.*\\)");
    assertThat(result).isEqualTo("a b c");
  }

  @Test
  public void removePatternAtEndOfString2() {
    String result = StringUtils.removePatternAtEndOfString("a b c(d e f)", "( )?\\(.*\\)");
    assertThat(result).isEqualTo("a b c");
  }

  @Test
  public void removePatternAtEndOfString3() {
    String result = StringUtils.removePatternAtEndOfString("a b c", "( )?\\(.*\\)");
    assertThat(result).isEqualTo("a b c");
  }
}