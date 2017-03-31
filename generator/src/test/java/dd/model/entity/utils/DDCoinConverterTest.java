package dd.model.entity.utils;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 18/12/2016.
 */
@SuppressWarnings("HardCodedStringLiteral")
public class DDCoinConverterTest {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test
  public void addCoinsOfSameCoinTypeShouldBeCorrect() {
    assertThat(DDCoinConverter.add("3 po", "5 po")).isEqualTo("8 po");
  }

  @Test
  public void addNullStringsShouldReturnEmptyString() {
    assertThat(DDCoinConverter.add(null, null)).isEqualTo("");
  }

  @Test
  public void addEmptyStringsShouldReturnEmptyString() {
    assertThat(DDCoinConverter.add("", "")).isEqualTo("");
  }

  @Test
  public void addCoinToNullStringShouldReturnCoin() {
    softly.assertThat(DDCoinConverter.add("20 po", null)).isEqualTo("20 po");
    softly.assertThat(DDCoinConverter.add(null, "18 po")).isEqualTo("18 po");
  }

  @Test
  public void addCoinToEmptyStringShouldReturnCoin() {
    softly.assertThat(DDCoinConverter.add("20 po", "")).isEqualTo("20 po");
    softly.assertThat(DDCoinConverter.add("", "18 po")).isEqualTo("18 po");
  }

  @Test
  public void addWithMissingSpaceShouldBeManaged() {
    softly.assertThat(DDCoinConverter.add("10po", "20 po")).isEqualTo("10po + 20 po");
    softly.assertThat(DDCoinConverter.add("10 po", "5po")).isEqualTo("10 po + 5po");
  }

  @Test
  public void addWithMissingCoinTypeShouldReturnUnknownValue() {
    softly.assertThat(DDCoinConverter.add("1", "2 po")).isEqualTo(DDCoinConverter.UNKNOWN_VALUE);
    softly.assertThat(DDCoinConverter.add("1 po", "2")).isEqualTo(DDCoinConverter.UNKNOWN_VALUE);
  }

  @Test
  public void addWithWrongCoinTypeShouldReturnUnknownValue() {
    softly.assertThat(DDCoinConverter.add("1 p", "2 po")).isEqualTo(DDCoinConverter.UNKNOWN_VALUE);
    softly.assertThat(DDCoinConverter.add("1 po", "2 p")).isEqualTo(DDCoinConverter.UNKNOWN_VALUE);
  }

  @Test
  public void addWithDifferentCoinTypeShouldReturnCorrectValue() {
    softly.assertThat(DDCoinConverter.add("1 po", "2 pa")).isEqualTo("1 po 2 pa");
  }
}