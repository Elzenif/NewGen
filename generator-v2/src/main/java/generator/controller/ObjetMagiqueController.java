package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ObjetMagique;
import generator.model.repository.ObjetMagiqueRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ObjetMagiqueController {

  private final ObjetMagiqueRepository objetMagiqueRepository;
  private final AnneauController anneauController;

  @Autowired
  public ObjetMagiqueController(ObjetMagiqueRepository objetMagiqueRepository, AnneauController anneauController) {
    this.objetMagiqueRepository = objetMagiqueRepository;
    this.anneauController = anneauController;
  }

  public String generate(String detailsRight) {
    String puissance = processInput(detailsRight);
    int r1 = MathUtils.random(1, 100);
    ObjetMagique objetMagique = objetMagiqueRepository
        .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
    String categorie = objetMagique.getCategorie();
    if (Objects.equals(categorie, "anneaux")) {
      return anneauController.generate(puissance);
    }
    return "ERROR ObjetMagique";
  }

  @NotNull
  private String processInput(String input) {
    if (input.contains("faible")) {
      return "faible";
    } else if (input.contains("intermédiaire")) {
      return "intermédiaire";
    } else if (input.contains("puissant")) {
      return "puissante";
    }
    String message = String.format("Input %s cannot be converted to puissance", input);
    throw new IllegalArgumentException(message);
  }
}
