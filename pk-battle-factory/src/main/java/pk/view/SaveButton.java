package pk.view;

import commons.Constants;
import commons.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Germain on 13/07/2017.
 */
@Component
public class SaveButton extends JButton implements ActionListener {

  private PkInfoTable pkInfoTable;
  private PokemonFactoryController pokemonFactoryController;

  public SaveButton() {
    super(Constants.resourceBundle.getString("save"));

    setEnabled(false);

    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    List<PokemonFactoryDTO> pokemonFactoryDTOS = pkInfoTable.getPokemonFactoryDTOS();
    int columnCount = pkInfoTable.getDataModel().getColumnCount();
    if (pokemonFactoryDTOS.isEmpty()) { // new line
      PokemonFactoryDTO pokemonFactoryDTO = pkInfoTable.getPokemonFactoryDTO(0, columnCount);
      String pkName = pokemonFactoryDTO.getPkName();
      if (StringUtils.isEmpty(pkName) || Objects.equals(pkName, "null")) {
        showError("error.missingPkName");
        return;
      }
      List<PokemonFactoryDTO> pokemonWithSameName = pokemonFactoryController.findByName(pkName);
      if (pokemonWithSameName.size() >= 4) {
        showError("error.tooManyPk");
        return;
      }
      pokemonFactoryController.insertNewPokemon(pokemonFactoryDTO);
      pkInfoTable.update(Collections.emptyList());
    } else { // compare existing
      int rowCount = pkInfoTable.getDataModel().getRowCount();
      for (int row = 0; row < rowCount; row++) {
        PokemonFactoryDTO existingDTO = pokemonFactoryDTOS.get(row);
        PokemonFactoryDTO pokemonFactoryDTO = pkInfoTable.getPokemonFactoryDTO(row, columnCount);
        if (!existingDTO.compareWithoutId(pokemonFactoryDTO)) {
          pokemonFactoryController.update(existingDTO.getId(), pokemonFactoryDTO);
        }
      }
    }

    setEnabled(false);
    pkInfoTable.setEditing(false);
  }

  private void showError(String key) {
    JOptionPane.showMessageDialog((SwingUtilities.getWindowAncestor(this)),
        Constants.resourceBundle.getString(key));
  }

  @Autowired
  public void setPkInfoTable(PkInfoTable pkInfoTable) {
    this.pkInfoTable = pkInfoTable;
  }

  @Autowired
  public void setPokemonFactoryController(PokemonFactoryController pokemonFactoryController) {
    this.pokemonFactoryController = pokemonFactoryController;
  }
}
