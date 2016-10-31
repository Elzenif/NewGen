package dd.controller.entity.items;

import commons.controller.entity.GenerateEntityActionListener;
import commons.model.commons.constraints.GenerationConstraints;
import commons.view.entity.EntityResultRow;
import dd.model.commons.DDGame;
import dd.model.entity.items.factory.DDCoinFactory;
import dd.model.entity.items.factory.DDNonPreciousItemFactory;
import dd.model.entity.items.factory.DDPreciousItemFactory;
import dd.view.entity.items.options.DDTreasureOptionRow;
import dd.view.entity.items.results.TreasureResult;

/**
 * Created by Germain on 27/10/2016.
 */
public class GenerateDDTreasureActionListener extends GenerateEntityActionListener<DDGame> {

  private final DDCoinFactory coinFactory;
  private final DDPreciousItemFactory preciousItemFactory;
  private final DDNonPreciousItemFactory itemFactory;

  public GenerateDDTreasureActionListener(DDTreasureOptionRow treasureOptionRow, EntityResultRow entityResultRow,
                                          DDTreasureController treasureController) {
    super(treasureOptionRow, entityResultRow, treasureController);

    coinFactory = DDCoinFactory.getInstance();
    preciousItemFactory = DDPreciousItemFactory.getInstance();
    itemFactory = DDNonPreciousItemFactory.getInstance();

    coinFactory.setNextFactory(preciousItemFactory);
    preciousItemFactory.setNextFactory(itemFactory);
  }

  @Override
  protected TreasureResult generateOneResult(GenerationConstraints generationConstraints) {
    return new TreasureResult(coinFactory.generateTreasures(generationConstraints));
  }
}
