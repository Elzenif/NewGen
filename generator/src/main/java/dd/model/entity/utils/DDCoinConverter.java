package dd.model.entity.utils;

import commons.utils.StringUtils;
import commons.utils.exception.ForbiddenValueException;
import commons.view.utils.Constants;
import org.jetbrains.annotations.NonNls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Germain on 18/12/2016.
 */
public class DDCoinConverter {

  public static final String UNKNOWN_VALUE = Constants.resourceBundle.getString("unknown_value");

  private static final Logger LOGGER = LoggerFactory.getLogger(DDCoinConverter.class);
  @NonNls
  private static final String COIN_VALUE_IS_NOT_SEPARATED_FROM_ITS_TYPE = "Coin value is not separated from its type";
  private static final Set<String> ACCEPTED_COIN_TYPES = Arrays.stream(EDDCoinType.values()).map(EDDCoinType::toString)
      .collect(Collectors.toSet());

  public static String add(String first, String second) {
    if (StringUtils.isEmpty(first) && StringUtils.isEmpty(second))
      return "";
    else if (StringUtils.isEmpty(first))
      return second;
    else if (StringUtils.isEmpty(second))
      return first;

    EnumMap<EDDCoinType, Integer> resultMap1;
    EnumMap<EDDCoinType, Integer> resultMap2;
    try {
      resultMap1 = fillMap(first);
      resultMap2 = fillMap(second);
    } catch (ForbiddenValueException e) {
      LOGGER.error(e.getMessage(), e);
      return UNKNOWN_VALUE;
    } catch (NumberFormatException e) {
      LOGGER.error(e.getMessage(), e);
      return first + " + " + second;
    }
    String result = "";
    for (EDDCoinType coinType : EDDCoinType.values()) {
      if (resultMap1.containsKey(coinType) && resultMap2.containsKey(coinType)) {
        result += String.valueOf(resultMap1.get(coinType) + resultMap2.get(coinType)) + " " + coinType;
      } else if (resultMap1.containsKey(coinType)) {
        result += String.valueOf(resultMap1.get(coinType)) + " " + coinType;
      } else if (resultMap2.containsKey(coinType)) {
        result += String.valueOf(resultMap2.get(coinType)) + " " + coinType;
      }
    }
    return result;
  }

  private static EnumMap<EDDCoinType, Integer> fillMap(String stringToParse) {
    EnumMap<EDDCoinType, Integer> resultMap = new EnumMap<>(EDDCoinType.class);
    Iterator<String> iterator = StringUtils.split(stringToParse).iterator();
    int coinValue = 0;
    boolean isInt = true;
    while (iterator.hasNext()) {
      String st = iterator.next();
      if (isInt) { // we expect a number (coin value)
        coinValue = Integer.valueOf(st);
      } else { // we expect a coin type
        if (isNotValidCoinType(st))
          throw new ForbiddenValueException(st + " is not a valid coin type");
        resultMap.put(EDDCoinType.valueOf(st.toUpperCase()), coinValue);
      }
      isInt = !isInt;
    }
    if (!isInt) { // means that the split is odd (ex: "10" instead of "10 po")
      throw new ForbiddenValueException(stringToParse + " is missing a coin type");
    }
    return resultMap;
  }


  private static boolean isNotValidCoinType(String s) {
    return !ACCEPTED_COIN_TYPES.contains(s);
  }
}
