package pk.view;

import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.model.dto.PokemonFactoryDTO;

import javax.annotation.PostConstruct;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static commons.Constants.resourceBundle;

/**
 * Created by Germain on 02/07/2017.
 */
@Component
public class PkInfoTable extends JTable {

  private final DefaultTableModel dataModel;
  private final Vector<String> columnNames = new Vector<>(
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
          resourceBundle.getString("encounter") + " 50",
          resourceBundle.getString("encounter") + " 100"
      ));
  private SaveButton saveButton;
  private PkNameComboBox nameComboBox;
  private PkMoveComboBox moveComboBox;
  private PkNatureComboBox natureComboBox;
  private PkItemComboBox itemComboBox;
  private boolean newLine;
  private boolean editing;
  private Vector<Vector<Object>> data;
  private List<PokemonFactoryDTO> pokemonFactoryDTOS;
  private PkInfoRow lastRowEdited;

  @Autowired
  public PkInfoTable() {
    dataModel = new DefaultTableModel(columnNames, 0);
    setModel(dataModel);
  }

  @PostConstruct
  public void init() {
    setupColumns();
    dataModel.addTableModelListener(this);
    editing = false;
  }

  @Override
  public Class<?> getColumnClass(int column) {
    return (column >= 3 && column <= 8) || column == 13 || column == 14 ? Integer.class : String.class;
  }

  public DefaultTableModel getDataModel() {
    return dataModel;
  }

  public List<PokemonFactoryDTO> getPokemonFactoryDTOS() {
    return pokemonFactoryDTOS;
  }

  public void update(List<PokemonFactoryDTO> pokemonFactoryDTOS) {
    newLine = false;
    this.pokemonFactoryDTOS = pokemonFactoryDTOS;
    data = new Vector<>();
    for (PokemonFactoryDTO pokemonFactoryDTO : pokemonFactoryDTOS) {
      Vector<Object> vector = new Vector<>();
      vector.add(pokemonFactoryDTO.getPkName());
      vector.add(pokemonFactoryDTO.getNatureName());
      vector.add(pokemonFactoryDTO.getItemName());
      vector.addAll(pokemonFactoryDTO.getStats());
      vector.addAll(pokemonFactoryDTO.getMoves());
      for (int i = 0; i < 4 - pokemonFactoryDTO.getMoves().size(); i++) {
        vector.add(null);
      }
      vector.add(pokemonFactoryDTO.getEncounter50());
      vector.add(pokemonFactoryDTO.getEncounter100());
      data.add(vector);
    }
    dataModel.setDataVector(data, columnNames);
    setupColumns();
  }

  public void newLine() {
    newLine = true;
    pokemonFactoryDTOS = Collections.emptyList();
    data = new Vector<>();
    Vector<Object> rowData = new Vector<>();
    for (int i = 0; i < getColumnCount(); i++) {
      rowData.add(null);
    }
    data.add(rowData);
    dataModel.setDataVector(data, columnNames);
    setupColumns();
  }

  private void setupColumns() {
    TableColumn nameColumn = getColumnModel().getColumn(0);
    nameColumn.setCellEditor(new ComboBoxCellEditor(nameComboBox));

    TableColumn natureColumn = getColumnModel().getColumn(1);
    natureColumn.setCellEditor(new ComboBoxCellEditor(natureComboBox));

    TableColumn itemColumn = getColumnModel().getColumn(2);
    itemColumn.setCellEditor(new ComboBoxCellEditor(itemComboBox));

    TableColumn hpColumn = getColumnModel().getColumn(3);
    hpColumn.setPreferredWidth(20);
    TableColumn atkColumn = getColumnModel().getColumn(4);
    atkColumn.setPreferredWidth(20);
    TableColumn defColumn = getColumnModel().getColumn(5);
    defColumn.setPreferredWidth(20);
    TableColumn spAtkColumn = getColumnModel().getColumn(6);
    spAtkColumn.setPreferredWidth(20);
    TableColumn spDefColumn = getColumnModel().getColumn(7);
    spDefColumn.setPreferredWidth(20);
    TableColumn speedColumn = getColumnModel().getColumn(8);
    speedColumn.setPreferredWidth(20);

    TableColumn move1Column = getColumnModel().getColumn(9);
    move1Column.setCellEditor(new ComboBoxCellEditor(moveComboBox));
    TableColumn move2Column = getColumnModel().getColumn(10);
    move2Column.setCellEditor(new ComboBoxCellEditor(moveComboBox));
    TableColumn move3Column = getColumnModel().getColumn(11);
    move3Column.setCellEditor(new ComboBoxCellEditor(moveComboBox));
    TableColumn move4Column = getColumnModel().getColumn(12);
    move4Column.setCellEditor(new ComboBoxCellEditor(moveComboBox));
  }

  @Override
  public void tableChanged(TableModelEvent e) {
    super.tableChanged(e);
    if (!editing) {
      if (saveButton != null) {
        saveButton.setEnabled(true);
      }
      editing = true;
    }
    if (!newLine) {
      int selectedRow = getSelectedRow();
      if (lastRowEdited != null && selectedRow >= 0) {
        PokemonFactoryDTO pokemonFactoryDTO = pokemonFactoryDTOS.get(selectedRow);
        lastRowEdited.showText(pokemonFactoryDTO);
      }
    }
  }

  @NotNull
  public PokemonFactoryDTO getPokemonFactoryDTO(int row, int columnCount) {
    List<Object> values = new ArrayList<>(columnCount);
    for (int col = 0; col < columnCount; col++) {
      values.add(getValueAt(row, col));
    }
    return new PokemonFactoryDTO(values);
  }


  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @Autowired
  public void setMoveComboBox(PkMoveComboBox moveComboBox) {
    this.moveComboBox = moveComboBox;
  }

  @Autowired
  public void setNatureComboBox(PkNatureComboBox natureComboBox) {
    this.natureComboBox = natureComboBox;
  }

  @Autowired
  public void setItemComboBox(PkItemComboBox itemComboBox) {
    this.itemComboBox = itemComboBox;
  }

  @Autowired
  public void setSaveButton(SaveButton saveButton) {
    this.saveButton = saveButton;
  }

  public void setEditing(boolean editing) {
    this.editing = editing;
  }

  public void setLastRowEdited(PkInfoRow lastRowEdited) {
    this.lastRowEdited = lastRowEdited;
  }
}
