package generator.controller;

import commons.utils.Pair;
import generator.model.entity.Tresor;
import generator.model.entity.TresorType;
import generator.model.repository.ObjetPuissantRepository;
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
public class TresorController extends AbstractController {

  private final TresorRepository tresorRepository;
  private final PiecesController piecesController;
  private final GemmeController gemmeController;
  private final ObjetArtController objetArtController;
  private final ObjetNonMagiqueController objetNonMagiqueController;
  private final ObjetMagiqueController objetMagiqueController;
  private final ObjetPuissantRepository objetPuissantRepository;

  @Autowired
  public TresorController(TresorRepository tresorRepository, PiecesController piecesController,
                          GemmeController gemmeController, ObjetArtController objetArtController,
                          ObjetNonMagiqueController objetNonMagiqueController,
                          ObjetMagiqueController objetMagiqueController,
                          ObjetPuissantRepository objetPuissantRepository) {
    this.tresorRepository = tresorRepository;
    this.piecesController = piecesController;
    this.gemmeController = gemmeController;
    this.objetArtController = objetArtController;
    this.objetNonMagiqueController = objetNonMagiqueController;
    this.objetMagiqueController = objetMagiqueController;
    this.objetPuissantRepository = objetPuissantRepository;
  }

  public String generate(Integer generationLevel) {
    int random = roll100();
    int level;
    int additonal = 0;
    if (generationLevel > 20) {
      level = 20;
      additonal = getNbObjetsPuissants(Math.min(30, generationLevel));
    } else {
      level = generationLevel;
    }
    List<Tresor> tresors = tresorRepository.findByNiveauAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(level,
        random, random);
    if (additonal > 0) {
      Tresor tresor = new Tresor();
      tresor.setType(TresorType.objets);
      tresor.setDetail(additonal + "xpuissants");
      tresors.add(tresor);
    }
    return tresors.stream()
        .filter(tresor -> tresor.getDetail() != null)
        .map(tresor -> convertTresor(tresor.getType(), tresor.getDetail()))
        .collect(Collectors.joining("<br/>"));
  }

  private int getNbObjetsPuissants(Integer generationLevel) {
    return objetPuissantRepository.findFirstByNiveau(generationLevel).getNb();
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
