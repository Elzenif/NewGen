package generator;

import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import commons.utils.exception.NoAvailableEntityTypeException;
import generator.model.entity.Tresor;
import generator.model.repository.TresorRepository;
import generator.utils.GeneratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Germain on 25/05/2017.
 */
@SpringComponent
@UIScope
public class TresorGenerator extends VerticalLayout {

  private static final Logger LOGGER = LoggerFactory.getLogger(TresorGenerator.class);

  private final TresorRepository tresorRepository;
  private final Grid<Tresor> tresorGrid;
  private int generationLevel = 1;
  private TextField levelField = new TextField("Niveau");
  private Button generateButton = new Button("Générer");

  public TresorGenerator(TresorRepository tresorRepository) {
    this.tresorRepository = tresorRepository;
    tresorGrid = new Grid<>(Tresor.class);

    addComponents(levelField, generateButton, tresorGrid);

    levelField.setValueChangeMode(ValueChangeMode.LAZY);
    levelField.addValueChangeListener(e -> generationLevel = Integer.valueOf(e.getValue()));
    generateButton.addClickListener(e -> generate());
    setVisible(true);
  }

  private void generate() {
    List<Tresor> tresors = tresorRepository.findByNiveau(generationLevel);
    try {
      Tresor tresor = GeneratorUtils.findOne(tresors);
      tresorGrid.setItems(tresor);
    } catch (NoAvailableEntityTypeException e) {
      String message = String.format("Could not find entity in %s", tresors);
      LOGGER.error(message, e);
    }
  }
}
