package pk.view;

import org.springframework.stereotype.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Vector;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkInfoTable extends JTable {

  private final DefaultTableModel dataModel;
  private Vector<String> columnNames = new Vector<>(
      Arrays.asList(resourceBundle.getString("name"),
          resourceBundle.getString("nature"),
          resourceBundle.getString("item"),
          resourceBundle.getString("hp"),
          resourceBundle.getString("atk"),
          resourceBundle.getString("def"),
          resourceBundle.getString("spAtk"),
          resourceBundle.getString("spDef"),
          resourceBundle.getString("speed"),
          resourceBundle.getString("move1"),
          resourceBundle.getString("move2"),
          resourceBundle.getString("move3"),
          resourceBundle.getString("move4")
          ));

  public PkInfoTable() {
    dataModel = new DefaultTableModel(columnNames, 0);
    setModel(dataModel);
  }

  public DefaultTableModel getDataModel() {
    return dataModel;
  }

  public Vector<String> getColumnNames() {
    return columnNames;
  }

  @Override
  public Class<?> getColumnClass(int column) {
    Object val = getValueAt(0, column);
    return val == null ? String.class : val.getClass();
  }
}
