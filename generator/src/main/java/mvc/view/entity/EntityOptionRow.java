package mvc.view.entity;

import mvc.controller.entity.GenerateItemActionListener;
import mvc.view.commons.PanelRow;

import javax.swing.JButton;
import java.util.List;

/**
 * Created by Germain on 05/06/2016.
 */
public class EntityOptionRow extends PanelRow {

  private JButton generateItemButton;

  EntityOptionRow() {
    super();
    setComponents();
  }

  private void setComponents() {
    generateItemButton = new JButton("Generate");
    add(generateItemButton);
  }

  void setControllers(List<EntityResultRow> entityResultRows) {
    generateItemButton.addActionListener(new GenerateItemActionListener(this, entityResultRows));
  }

}
