package mvc.view.entity;

import mvc.view.commons.DoublePanel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 04/06/2016.
 */
public class EntityPanel extends DoublePanel {

  private static final int NB_OPTIONS_ROWS = 4;
  private static final int NB_RESULTS_ROWS = 10;

  public EntityPanel() {
    super(setPanel("Options", NB_OPTIONS_ROWS, 1), setPanel("Results", NB_RESULTS_ROWS, 1));
  }

  protected void setPanelsComponents() {
    EntityOptionRow entityOptionRow = new EntityOptionRow();
    leftPanel.add(entityOptionRow);

    List<EntityResultRow> entityResultRows = new LinkedList<>();
    for (int i = 0; i < NB_RESULTS_ROWS; i ++) {
      EntityResultRow entityResultRow = new EntityResultRow();
      entityResultRows.add(entityResultRow);
      rightPanel.add(entityResultRow);
    }

    entityOptionRow.setControllers(entityResultRows);
  }

}
