package generator.controller;

import generator.model.entity.Gemme;
import generator.model.repository.GemmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class GemmeController extends AbstractController {

  private final PiecesController piecesController;
  private final GemmeRepository gemmeRepository;

  @Autowired
  public GemmeController(PiecesController piecesController, GemmeRepository gemmeRepository) {
    this.piecesController = piecesController;
    this.gemmeRepository = gemmeRepository;
  }

  public String generate() {
    Gemme gemme = gemmeRepository.findRandom(roll100());
    return piecesController.chooseRandomAndAddValue(gemme.getExemples(), ";", gemme.getValeur());
  }
}
