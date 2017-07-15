package pk.view;

import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PkNameActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Created by Germain on 01/07/2017.
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOwnInfoRow extends PkInfoRow {

  private final PkNameActionListener pkNameActionListener;

  private PkNameComboBox nameComboBox;

  private JPanel leftPanel;
  private JPanel rightPanel;
  private CardLayout cardLayout;
  private JLabel label;
  private JTextPane textPane;

  @Autowired
  public PkOwnInfoRow(PkNameActionListener pkNameActionListener) {
    this.pkNameActionListener = pkNameActionListener;
    setLayout(new GridLayout(1, 2, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @PostConstruct
  public void init() {
    leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Constants.JPANEL_HGAP, Constants.JPANEL_VGAP));
    JLabel name = new JLabel(Constants.resourceBundle.getString("name"));
    leftPanel.add(name);

    nameComboBox.setEditable(true);
    leftPanel.add(nameComboBox);

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

    nameComboBox.addActionListener(pkNameActionListener);
  }

  public JLabel getLabel() {
    return label;
  }

  public JTextPane getTextPane() {
    return textPane;
  }
}
