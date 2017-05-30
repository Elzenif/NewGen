package generator;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import generator.controller.TresorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Germain on 25/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@SpringComponent
@UIScope
public class TresorGenerator extends VerticalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(TresorGenerator.class);

  private final TresorController tresorController;
  private int generationLevel = 1;
  private TextField levelField = new TextField("Niveau");
  private Button generateButton = new Button("Générer");
  private Label resultLabel;

  @Autowired
  public TresorGenerator(TresorController tresorController) {
    this.tresorController = tresorController;

    addComponents(levelField, generateButton);

    levelField.setValueChangeMode(ValueChangeMode.LAZY);
    levelField.addValueChangeListener(e -> generationLevel = Integer.valueOf(e.getValue()));
    generateButton.addClickListener(e -> generateAndPrint());
    setVisible(true);
  }

  private void generateAndPrint() {
    String text = tresorController.generate(generationLevel);
    resultLabel = new Label();
    resultLabel.setContentMode(ContentMode.HTML);
    resultLabel.setValue(text.isEmpty() ? "Rien" : text);
    addComponent(resultLabel);
  }
}
