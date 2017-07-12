package pk.view;

import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
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
          resourceBundle.getString("move") + " 1",
          resourceBundle.getString("move") + " 2",
          resourceBundle.getString("move") + " 3",
          resourceBundle.getString("move") + " 4",
          resourceBundle.getString("encounter") + " 100"
          ));

  public PkInfoTable() {
    dataModel = new DefaultTableModel(columnNames, 0);
    setModel(dataModel);
  }

  @Override
  public Class<?> getColumnClass(int column) {
    Object val = getValueAt(0, column);
    return val == null ? String.class : val.getClass();
  }

  public void update(List<PokemonFactoryDTO> pokemonFactoryDTOS) {
    Vector<Vector<Object>> data = new Vector<>();
    for (PokemonFactoryDTO pokemonFactoryDTO : pokemonFactoryDTOS) {
      Vector<Object> vector = new Vector<>();
      vector.add(pokemonFactoryDTO.getPkName());
      vector.add(pokemonFactoryDTO.getNatureName());
      vector.add(pokemonFactoryDTO.getItemName());
      vector.addAll(pokemonFactoryDTO.getStats());
      vector.addAll(pokemonFactoryDTO.getMoves());
      vector.add(pokemonFactoryDTO.getEncounter100());
      data.add(vector);
    }
    dataModel.setDataVector(data, columnNames);
  }
}
