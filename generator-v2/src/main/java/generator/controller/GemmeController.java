package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.Gemme;
import generator.model.repository.GemmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 28/05/2017.
 */
@Service
public class GemmeController {

  private final PiecesController piecesController;
  private final GemmeRepository gemmeRepository;

  @Autowired
  public GemmeController(PiecesController piecesController, GemmeRepository gemmeRepository) {
    this.piecesController = piecesController;
    this.gemmeRepository = gemmeRepository;
  }

  public String generate() {
    int random = MathUtils.random(1, 100);
    Gemme gemme = gemmeRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(random, random);
    return piecesController.chooseRandomAndAddValue(gemme.getExemples(), ";", gemme.getValeur());
  }
}
