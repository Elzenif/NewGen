package commons.utils;

import com.google.common.collect.ForwardingSet;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Germain on 12/06/2016.
 */
public class CollectionUtils {

  @Contract(value = "_, _ -> !null", pure = true)
  public static <T> Set<T> setMaxSizeSet(final Set<T> input, final int maxSize) {
    return new ForwardingSet<T>() {

      private void checkSize() {
        if (size() >= maxSize)
          throw new UnsupportedOperationException("Maximum size " + maxSize + " reached");
      }

      @Override
      public boolean add(T element) {
        checkSize();
        return delegate().add(element);
      }

      @Override
      public boolean addAll(@NotNull Collection<? extends T> collection) {
        return standardAddAll(collection);
      }

      @Contract(pure = true)
      @Override
      protected Set<T> delegate() {
        return input;
      }
    };
  }

  @Contract(pure = true)
  public static <T> boolean containsOnlyNull(Collection<T> collection) {
    if (collection.isEmpty()) {
      return false;
    }
    for (T t : collection) {
      if (t != null) {
        return false;
      }
    }
    return true;
  }


  public static <T> boolean doesNotContainNull(Collection<T> collection) {
    if (collection.isEmpty()) {
      return true;
    }
    for (T t : collection) {
      if (t == null) {
        return false;
      }
    }
    return true;
  }

  @Contract("null -> true")
  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }
}
