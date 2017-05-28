package generator;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import commons.utils.exception.NoAvailableEntityTypeException;
import generator.controller.TresorController;
import generator.model.entity.Tresor;
import generator.model.repository.TresorRepository;
import generator.utils.GeneratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Germain on 25/05/2017.
 */
@SpringComponent
@UIScope
public class TresorGenerator extends VerticalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(TresorGenerator.class);

  private final TresorRepository tresorRepository;
  private final TresorController tresorController;
  private int generationLevel = 1;
  private TextField levelField = new TextField("Niveau");
  private Button generateButton = new Button("Générer");
  private Label resultLabel;

  public TresorGenerator(TresorRepository tresorRepository, TresorController tresorController) {
    this.tresorRepository = tresorRepository;
    this.tresorController = tresorController;

    addComponents(levelField, generateButton);

    levelField.setValueChangeMode(ValueChangeMode.LAZY);
    levelField.addValueChangeListener(e -> generationLevel = Integer.valueOf(e.getValue()));
    generateButton.addClickListener(e -> generate());
    setVisible(true);
  }

  private void generate() {
    List<Tresor> tresors = tresorRepository.findByNiveau(generationLevel);
    try {
      resultLabel = new Label();
      resultLabel.setContentMode(ContentMode.HTML);
      tresors = GeneratorUtils.findAll(tresors);
      String text = tresors.stream()
          .filter(tresor -> tresor.getDetail() != null)
          .map(tresor -> tresorController.convertTresor(tresor.getType(), tresor.getDetail()))
          .collect(Collectors.joining("<br/>"));
      resultLabel.setValue(text.isEmpty() ? "Rien" : text);
      addComponent(resultLabel);
    } catch (NoAvailableEntityTypeException e) {
      String message = String.format("Could not find entity in %s", tresors);
      LOGGER.error(message, e);
    }
  }
}
