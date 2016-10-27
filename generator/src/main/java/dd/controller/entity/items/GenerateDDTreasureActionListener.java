package dd.controller.entity.items;

import commons.controller.entity.GenerateEntityActionListener;
import commons.model.commons.constraints.GenerationConstraints;
import commons.view.entity.EntityResultRow;
import dd.model.commons.DDGame;
import dd.model.entity.items.factory.DDCoinFactory;
import dd.view.entity.items.options.DDTreasureOptionRow;
import dd.view.entity.items.results.TreasureResult;

/**
 * Created by Germain on 27/10/2016.
 */
public class GenerateDDTreasureActionListener extends GenerateEntityActionListener<DDGame> {

  private final DDCoinFactory coinFactory;

  public GenerateDDTreasureActionListener(DDTreasureOptionRow treasureOptionRow, EntityResultRow entityResultRow,
                                          DDTreasureController treasureController) {
    super(treasureOptionRow, entityResultRow, treasureController);

    coinFactory = new DDCoinFactory();
  }

  // FIXME bug when clicking on options, the value inside the level is not taken into account
  @Override
  protected TreasureResult generateOneResult(GenerationConstraints generationConstraints) {
    return new TreasureResult(coinFactory.generateTreasures(generationConstraints));
  }
}
