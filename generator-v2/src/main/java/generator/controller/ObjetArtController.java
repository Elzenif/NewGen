package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ObjetArt;
import generator.model.repository.ObjetArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ObjetArtController {

  private final PiecesController piecesController;
  private final ObjetArtRepository objetArtRepository;

  @Autowired
  public ObjetArtController(PiecesController piecesController, ObjetArtRepository objetArtRepository) {
    this.piecesController = piecesController;
    this.objetArtRepository = objetArtRepository;
  }

  public String generate() {
    int random = MathUtils.random(1, 100);
    ObjetArt objetArt = objetArtRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(random, random);
    return piecesController.chooseRandomAndAddValue(objetArt.getExemples(), ";", objetArt.getValeur());
  }
}
