package generator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import generator.model.entity.Tresor;
import generator.model.repository.TresorRepository;

import java.util.Collection;

/**
 * Created by Germain on 25/05/2017.
 */
@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

  private TresorRepository tresorRepository;
  private Grid<Tresor> tresorGrid;

  public VaadinUI(TresorRepository tresorRepository) {
    this.tresorRepository = tresorRepository;
    this.tresorGrid = new Grid<>(Tresor.class);
  }

  @Override
  protected void init(VaadinRequest request) {
    setContent(tresorGrid);
    listTresors();
  }

  private void listTresors() {
    tresorGrid.setItems((Collection<Tresor>) tresorRepository.findAll());
  }
}
