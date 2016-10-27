package nbk.controller.map;

import commons.controller.commons.AbstractOptionRowController;
import commons.controller.entity.items.ConstraintsItemListener;
import commons.controller.intf.HasDrawKeysController;
import commons.controller.map.SaveMapActionListener;
import commons.controller.map.ShowGridItemListener;
import commons.controller.map.ZoomChangeListener;
import commons.model.commons.IDrawKey;
import commons.view.map.MapResultRow;
import nbk.controller.utility.DrawChangeListener;
import nbk.model.map.dungeon.constraints.EDungeonDraw;
import nbk.view.map.options.NbkDungeonOptionRow;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 26/09/2016.
 */
public class NbkDungeonController extends AbstractOptionRowController implements HasDrawKeysController<IDrawKey> {

  private final NbkDungeonOptionRow dungeonOptionRow;
  private final SaveMapActionListener saveMapActionListener;
  private final ShowGridItemListener showGridItemListener;
  private final ZoomChangeListener zoomChangeListener;

  private final Map<IDrawKey, DrawChangeListener> drawChangeListenerMap
      = new LinkedHashMap<>(EDungeonDraw.values().length);

  public NbkDungeonController(NbkDungeonOptionRow dungeonOptionRow, MapResultRow mapResultRow) {
    super(new ConstraintsItemListener(dungeonOptionRow));

    this.dungeonOptionRow = dungeonOptionRow;
    generateActionListener = new GenerateNbkDungeonActionListener(dungeonOptionRow, mapResultRow, this);
    saveMapActionListener = new SaveMapActionListener(dungeonOptionRow, mapResultRow);
    showGridItemListener = new ShowGridItemListener(mapResultRow);
    zoomChangeListener = new ZoomChangeListener(mapResultRow);

    Arrays.stream(EDungeonDraw.values()).forEach(dungeonDraw -> {
      drawChangeListenerMap.put(dungeonDraw, new DrawChangeListener(this, dungeonDraw));
      generationConstraints.getMapConstraint().put(dungeonDraw, dungeonDraw.getDefaultValue());
    });
  }

  public SaveMapActionListener getSaveMapActionListener() {
    return saveMapActionListener;
  }

  @Override
  public DrawChangeListener getDrawChangeListener(IDrawKey dungeonDraw) {
    return drawChangeListenerMap.get(dungeonDraw);
  }

  @Override
  public void updateDrawKeyValue(IDrawKey drawKey) {
    generationConstraints.getMapConstraint().put(drawKey, dungeonOptionRow.getDrawValue(drawKey));
  }

  public ShowGridItemListener getShowGridItemListener() {
    return showGridItemListener;
  }

  public ZoomChangeListener getZoomChangeListener() {
    return zoomChangeListener;
  }
}
