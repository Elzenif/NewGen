package pk.view;

import commons.Constants;
import commons.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;
import pk.model.dto.PokemonFactoryDTO;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

/**
 * Created by Germain on 13/07/2017.
 */
@Component
public class SaveButton extends JButton implements ActionListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(SaveButton.class);
  private NewLineButton newLineButton;
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
      LOGGER.info(pokemonFactoryDTO.toString());
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
    newLineButton.setEnabled(true);
  }

  private void showError(String key) {
    JOptionPane.showMessageDialog((SwingUtilities.getWindowAncestor(this)),
        Constants.resourceBundle.getString(key));
  }

  @Autowired
  public void setNewLineButton(NewLineButton newLineButton) {
    this.newLineButton = newLineButton;
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
