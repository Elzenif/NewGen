package generator.controller;

import generator.model.entity.ObjetArt;
import generator.model.repository.ObjetArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ObjetArtController extends AbstractController {

  private final PiecesController piecesController;
  private final ObjetArtRepository objetArtRepository;

  @Autowired
  public ObjetArtController(PiecesController piecesController, ObjetArtRepository objetArtRepository) {
    this.piecesController = piecesController;
    this.objetArtRepository = objetArtRepository;
  }

  public String generate() {
    ObjetArt objetArt = objetArtRepository.findRandom(roll100());
    return piecesController.chooseRandomAndAddValue(objetArt.getExemples(), ";", objetArt.getValeur());
  }
}
