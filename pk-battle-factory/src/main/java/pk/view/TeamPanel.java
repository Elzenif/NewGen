package pk.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
public abstract class TeamPanel extends GridLayout {

  public TeamPanel(String title, int rows) {
    super(1, rows);
    setCaption(title);
    for (int i = 0; i < rows; i++) {
      setColumnExpandRatio(i, 1F);
      setRowExpandRatio(i, 1F);
      setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
    }
  }
}
