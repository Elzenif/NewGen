package generator.controller;

import commons.utils.MathUtils;
import commons.utils.Pair;
import generator.model.entity.Tresor;
import generator.model.entity.TresorType;
import generator.model.repository.TresorRepository;
import generator.utils.GeneratorUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Germain on 27/05/2017.
 */
@Service
@SuppressWarnings("SpellCheckingInspection")
public class TresorController {

  private final TresorRepository tresorRepository;
  private final PiecesController piecesController;
  private final GemmeController gemmeController;
  private final ObjetArtController objetArtController;
  private final ObjetNonMagiqueController objetNonMagiqueController;
  private final ObjetMagiqueController objetMagiqueController;

  @Autowired
  public TresorController(TresorRepository tresorRepository, PiecesController piecesController,
                          GemmeController gemmeController, ObjetArtController objetArtController,
                          ObjetNonMagiqueController objetNonMagiqueController,
                          ObjetMagiqueController objetMagiqueController) {
    this.tresorRepository = tresorRepository;
    this.piecesController = piecesController;
    this.gemmeController = gemmeController;
    this.objetArtController = objetArtController;
    this.objetNonMagiqueController = objetNonMagiqueController;
    this.objetMagiqueController = objetMagiqueController;
  }

  public String generate(Integer generationLevel) {
    int random = MathUtils.random(1, 100);
    List<Tresor> tresors = tresorRepository.findByNiveauAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(generationLevel,
        random, random);
    return tresors.stream()
        .filter(tresor -> tresor.getDetail() != null)
        .map(tresor -> convertTresor(tresor.getType(), tresor.getDetail()))
        .collect(Collectors.joining("<br/>"));
  }


  String convertTresor(TresorType tresorType, @NotNull String detail) {
    if (tresorType == TresorType.pieces) {
      return piecesController.generate(detail);
    } else {
      Pair<Integer, String> pair = GeneratorUtils.getMultiplier(detail);
      Integer multiplier = pair.getLeft();
      String detailsRight = pair.getRight();
      return IntStream.rangeClosed(1, multiplier).boxed()
          .map(operand -> generate(detailsRight))
          .collect(Collectors.joining("<br/>"));
    }
  }

  private String generate(String detailsRight) {
    if (Objects.equals(detailsRight, "gemme") || Objects.equals(detailsRight, "gemmes")) {
      return gemmeController.generate();
    } else if (Objects.equals(detailsRight, "objet_art") || Objects.equals(detailsRight, "objets_art")) {
      return objetArtController.generate();
    } else if (Objects.equals(detailsRight, "non_magique")) {
      return objetNonMagiqueController.generate();
    } else {
      return objetMagiqueController.generate(detailsRight);
    }
  }
}
