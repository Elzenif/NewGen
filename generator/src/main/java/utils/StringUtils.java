package utils;

/**
 * Created by Germain on 22/05/2016.
 */
public class StringUtils {

  public static String fixedLengthString(int length, String string) {
    return String.format("%1$" + length + "s", string);
  }

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
}
