package generator.controller;

import commons.utils.Pair;
import generator.model.entity.TresorType;
import generator.utils.GeneratorUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Germain on 27/05/2017.
 */
@Service
public class TresorController {

  private final PiecesController piecesController;
  private final GemmeController gemmeController;
  private final ObjetArtController objetArtController;

  @Autowired
  public TresorController(PiecesController piecesController, GemmeController gemmeController,
                          ObjetArtController objetArtController) {
    this.piecesController = piecesController;
    this.gemmeController = gemmeController;
    this.objetArtController = objetArtController;
  }

  public String convertTresor(TresorType tresorType, @NotNull String detail) {
    if (tresorType == TresorType.pieces) {
      return piecesController.generate(detail);
    } else {
      Pair<Integer, String> pair = GeneratorUtils.getMultiplier(detail);
      Integer multiplier = pair.getLeft();
      String detailsRight = pair.getRight();
      List<String> results = new ArrayList<>();
      return IntStream.rangeClosed(1, multiplier).boxed()
          .map(operand -> generate(detailsRight))
          .collect(Collectors.joining("<br/>"));
    }
  }

  @SuppressWarnings("SpellCheckingInspection")
  private String generate(String detailsRight) {
    if (Objects.equals(detailsRight, "gemme") || Objects.equals(detailsRight, "gemmes")) {
      return gemmeController.generate();
    } else if (Objects.equals(detailsRight, "objet_art") || Objects.equals(detailsRight, "objets_art")) {
      return objetArtController.generate();
    }
    return "ERROR";
  }
}
