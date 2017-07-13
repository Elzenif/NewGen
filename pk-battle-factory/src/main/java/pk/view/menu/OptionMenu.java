package pk.view.menu;

import commons.Constants;
import org.springframework.stereotype.Component;
import pk.view.PkGenerationAware;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Germain on 11/07/2017.
 */
@Component
public class OptionMenu extends JMenu {

  private final JMenu generationMenu;
  private final ButtonGroup generationButtonGroup;
  private int selectedGeneration = 4;

  private List<PkGenerationAware> pkGenerationAwareElements = new ArrayList<>();

  public OptionMenu() {
    setText(Constants.resourceBundle.getString("menu.options"));
    generationMenu = new JMenu(Constants.resourceBundle.getString("menu.options.generation"));

    generationButtonGroup = new ButtonGroup();
    IntStream.rangeClosed(3, 4).forEach(g -> {
      JRadioButtonMenuItem rb = new JRadioButtonMenuItem(String.valueOf(g), g == 4);
      generationButtonGroup.add(rb);
      generationMenu.add(rb);
      rb.addActionListener(new GenerationActionListener(g));
    });

    add(generationMenu);
  }

  public int getSelectedGeneration() {
    return selectedGeneration;
  }

  public void addPkGenerationAware(PkGenerationAware pkGenerationAware) {
    pkGenerationAwareElements.add(pkGenerationAware);
  }

  private class GenerationActionListener implements ActionListener {

    private final int generation;

    public GenerationActionListener(int generation) {
      this.generation = generation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      selectedGeneration = generation;
      for (PkGenerationAware pkGenerationAwareElement : pkGenerationAwareElements) {
        pkGenerationAwareElement.updateGeneration();
      }
    }
  }
}
