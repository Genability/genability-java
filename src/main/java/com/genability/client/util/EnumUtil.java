package com.genability.client.util;

import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class EnumUtil {

  @SuppressWarnings("unchecked")
  public static <E extends Enum<E>> E[] parseEnumList(String list, Class<E> clazz) {
    if (list == null) {
      return null;
    }
    final StringTokenizer tok = new StringTokenizer(list, ",");
    final int count = tok.countTokens();
    final E[] chargeTypes = (E[]) Array.newInstance(clazz, count);
    int i = 0;
    while (tok.hasMoreTokens()) {
      String name = tok.nextToken();
      E value = Enum.valueOf(clazz, name);
      chargeTypes[i++] = value;
    }
    return chargeTypes;
  }

  public static <E extends Enum<E>> String enumListString(E[] list) {
    if (list == null) {
      return null;
    }
    final StringBuilder sb = new StringBuilder();
    final int length = list.length;
    for (int i = 0; length > i; ++i) {
      if (i != 0) {
        sb.append(',');
      }
      E value = list[i];
      sb.append(value);
    }
    return sb.toString();
  }

}
