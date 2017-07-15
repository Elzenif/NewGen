package commons.utils;

import com.google.common.base.Splitter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Germain on 22/05/2016.
 */
public class StringUtils {

  private static final DecimalFormat format = setFormat();

  @NotNull
  public static String center(int length, String string) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < (length - string.length()) / 2; i++) {
      sb.append(" ");
    }
    sb.append(string);
    while (sb.length() < length) {
      sb.append(" ");
    }
    return sb.toString();
  }

  @NotNull
  public static String leftAlign(int length, String string) {
    StringBuilder sb = new StringBuilder(length);
    sb.append(string);
    while (sb.length() < length) {
      sb.append(" ");
    }
    return sb.toString();
  }

  public static String capitalizeFirstLetter(String string, boolean lowerCase) {
    return lowerCase
            ? string.substring(0, 1).toUpperCase() + string.toLowerCase().substring(1)
            : string.substring(0, 1).toUpperCase() + string.substring(1);

  }

  private static DecimalFormat setFormat() {
    DecimalFormat format = new DecimalFormat("#.###", DecimalFormatSymbols.getInstance(Locale.FRANCE));
    format.setRoundingMode(RoundingMode.DOWN);
    return format;
  }

  public static String format(double nb) {
    return format.format(nb);
  }

  @NotNull
  public static Iterable<String> split(String string) {
    return Splitter.on(" ").split(string);
  }

  public static String removePatternAtEndOfString(String s, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
      return s.substring(0, matcher.start());
    }
    return s;
  }

  @Contract(value = "null -> true", pure = true)
  public static boolean isEmpty(String s) {
    return s == null || s.isEmpty();
  }
}
