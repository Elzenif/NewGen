package gen3.view.commons;

import commons.view.commons.GenTabbedPanelEmbedded;
import gen3.model.commons.Gen3;

/**
 * Created by Germain on 02/04/2017.
 */
public class Gen3TabbedPanelEmbedded extends GenTabbedPanelEmbedded {

  public Gen3TabbedPanelEmbedded() {
    super(Gen3.getInstance());
// TODO continue
//    Gen3StatCalculatorPanel gen3StatCalculatorPanel = new Gen3StatCalculatorPanel();
//    controllers.add(gen3StatCalculatorPanel);
//    panelMap.put(resourceBundle.getString("panel.stats"), gen3StatCalculatorPanel);

    addPanels();
  }
}
