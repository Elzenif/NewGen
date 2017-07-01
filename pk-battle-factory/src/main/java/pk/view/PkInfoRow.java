package pk.view;

import commons.Constants;
import pk.controller.PkDocumentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
public class PkInfoRow extends JPanel {

  private final JPanel leftPanel;
  private final JTextField nameTextField;
  private final JPanel rightPanel;
  private final CardLayout cardLayout;
  private final JLabel label;
  private final JTextPane textPane;

  public PkInfoRow() {
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));

    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    leftPanel.add(name);
    nameTextField = new JTextField(12);
    leftPanel.add(nameTextField);

    rightPanel = new JPanel();
    cardLayout = new CardLayout();
    rightPanel.setLayout(cardLayout);
    label = new JLabel();
    rightPanel.add("false", label);
    textPane = new JTextPane();
    rightPanel.add("true", textPane);
    cardLayout.show(rightPanel, "false");

    add(leftPanel);
    add(rightPanel);

    nameTextField.getDocument().addDocumentListener(new PkDocumentListener(this));
  }

  public JLabel getLabel() {
    return label;
  }

  public JTextPane getTextPane() {
    return textPane;
  }
}
