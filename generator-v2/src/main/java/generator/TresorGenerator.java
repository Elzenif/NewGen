package generator;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import commons.utils.MathUtils;
import generator.controller.TresorController;
import generator.model.entity.Tresor;
import generator.model.repository.TresorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

  @Autowired
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
    int random = MathUtils.random(1, 100);
    List<Tresor> tresors = tresorRepository.findByNiveauAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(generationLevel,
        random, random);
    resultLabel = new Label();
    resultLabel.setContentMode(ContentMode.HTML);
    String text = tresors.stream()
        .filter(tresor -> tresor.getDetail() != null)
        .map(tresor -> tresorController.convertTresor(tresor.getType(), tresor.getDetail()))
        .collect(Collectors.joining("<br/>"));
    resultLabel.setValue(text.isEmpty() ? "Rien" : text);
    addComponent(resultLabel);
  }
}
