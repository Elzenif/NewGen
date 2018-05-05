package pk.view.main;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germain on 01/07/2017.
 */
public abstract class TeamPanel<T extends PkInfoRow> extends GridLayout {

  private final List<T> pkInfoRows = new ArrayList<>();

  protected TeamPanel(String title, int rows) {
    super(1, rows);
    setCaption(title);
    for (int i = 0; i < rows; i++) {
      setColumnExpandRatio(i, 1F);
      setRowExpandRatio(i, 1F);
      setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
    }
  }

  protected void add(T pkInfoRow) {
    addComponent(pkInfoRow);
    pkInfoRows.add(pkInfoRow);
  }

  public List<T> getPkInfoRows() {
    return pkInfoRows;
  }
}
