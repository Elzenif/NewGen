package pk.view;

import commons.Constants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.FlowLayout;

/**
 * Created by Germain on 11/07/2017.
 */
public abstract class PkInfoRow extends JPanel {

  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JLabel label;
  private JTextArea textArea;

  public PkInfoRow() {
    setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, 1));
  }

  protected void preInit() {
  }

  protected void postInit() {
    rightPanel = new JPanel();
    cardLayout = new CardLayout();
    rightPanel.setLayout(cardLayout);
    label = new JLabel();
    rightPanel.add("false", label);
    textArea = new JTextArea();
    textArea.setOpaque(false);
    textArea.setRows(7);
    rightPanel.add("true", textArea);
    cardLayout.show(rightPanel, "false");

    add(rightPanel);
  }

  public void showText(String text) {
    textArea.setText(text);
    cardLayout.show(rightPanel, "true");
  }
}
