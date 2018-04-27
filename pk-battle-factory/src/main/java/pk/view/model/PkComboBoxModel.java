package pk.view.model;

import java.util.List;
import java.util.function.Function;

/**
 * Created by Germain on 12/07/2017.
 */
public interface PkComboBoxModel<T> {

  List<T> getAllElements();

  Function<T, String> getCaptionGenerator();
}
