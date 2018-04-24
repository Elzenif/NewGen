package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Germain on 13/07/2017.
 */
@Component
public class NewLineButton extends JButton implements ActionListener {

  private PkInfoGrid pkInfoGrid;

  @Autowired
  public NewLineButton() {
    super(Constants.resourceBundle.getString("newLine"));

    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    pkInfoGrid.newLine();
  }

  @Autowired
  public void setPkInfoGrid(PkInfoGrid pkInfoGrid) {
    this.pkInfoGrid = pkInfoGrid;
  }
}
