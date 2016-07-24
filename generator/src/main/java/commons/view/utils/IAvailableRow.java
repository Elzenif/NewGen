package commons.view.utils;

/**
 * Created by Germain on 24/07/2016.
 */
public interface IAvailableRow<O extends OptionRow<R>, R extends ResultRow> {

  O getOptionRow();
  R getResultRow();
}
