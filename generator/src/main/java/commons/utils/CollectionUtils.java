package commons.utils;

import com.google.common.collect.ForwardingList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Created by Germain on 12/06/2016.
 */
public class CollectionUtils {

  @Contract(value = "_, _ -> !null", pure = true)
  public static <T> List<T> setMaxSize(final List<T> input, final int maxSize) {
    return new ForwardingList<T>() {

      private void checkSize() {
        if (size() >= maxSize)
          throw new UnsupportedOperationException("Maximum size " + maxSize + " reached");
      }

      @Override
      public void add(int index, T element) {
        checkSize();
        delegate().add(index, element);
      }

      @Override
      public boolean addAll(int index, Collection<? extends T> elements) {
        return standardAddAll(index, elements);
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
      protected List<T> delegate() {
        return input;
      }
    };
  }

}
