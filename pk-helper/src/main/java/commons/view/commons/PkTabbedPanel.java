package commons.view.commons;

import commons.controller.intf.Controller;
import commons.utils.CollectionUtils;
import commons.view.PkMainFrame;
import commons.view.intf.IMainTabbedPanel;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Germain on 02/04/2017.
 */
public class PkTabbedPanel extends JPanel implements IMainTabbedPanel<PkMainFrame> {

  private final CardLayout cardLayout;
  private final Set<GenTabbedPanelEmbedded> tabbedPanels;

  private final List<Controller<PkMainFrame>> controllers = new ArrayList<>();

  public PkTabbedPanel() {
    cardLayout = new CardLayout();
    setLayout(cardLayout);
    tabbedPanels = CollectionUtils.setMaxSizeSet(new HashSet<>(), EAvailableGen.NB_GENS);

    Arrays.stream(EAvailableGen.values()).forEach(gen -> {
      GenTabbedPanelEmbedded genTabbedPanelEmbedded = gen.getTabbedPanelEmbedded();
      tabbedPanels.add(genTabbedPanelEmbedded);
      controllers.add(genTabbedPanelEmbedded);
      add(gen.getGen().getRomanNumber(), genTabbedPanelEmbedded);
    });

    cardLayout.show(this, EAvailableGen.getDefault().getRomanNumber());
  }

  @Override
  public List<Controller<PkMainFrame>> getControllers() {
    return controllers;
  }
}
