package generator.controller;

import generator.model.entity.ObjetMagique;
import generator.model.repository.ObjetMagiqueRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ObjetMagiqueController extends AbstractController {

  private final ObjetMagiqueRepository objetMagiqueRepository;
  private final ArmeController armeController;
  private final ArmureEtBouclierController armureEtBouclierController;
  private final OtherController otherController;
  private final ParcheminController parcheminController;

  @Autowired
  public ObjetMagiqueController(ObjetMagiqueRepository objetMagiqueRepository, ArmeController armeController,
                                ArmureEtBouclierController armureEtBouclierController, OtherController otherController,
                                ParcheminController parcheminController) {
    this.objetMagiqueRepository = objetMagiqueRepository;
    this.armeController = armeController;
    this.armureEtBouclierController = armureEtBouclierController;
    this.otherController = otherController;
    this.parcheminController = parcheminController;
  }

  public String generate(String detailsRight) {
    String puissance = processInput(detailsRight);
    int r1 = roll100();
    ObjetMagique objetMagique = objetMagiqueRepository.findRandomByPuissance(puissance, r1);
    String categorie = objetMagique.getCategorie();
    if (Objects.equals(categorie, "anneaux")) {
      return otherController.generateAnneau(puissance);
    } else if (Objects.equals(categorie, "armes")) {
      return armeController.generate(puissance);
    } else if (Objects.equals(categorie, "armures et boucliers")) {
      return armureEtBouclierController.generate(puissance);
    } else if (Objects.equals(categorie, "baguettes")) {
      return otherController.generateBaguette(puissance);
    } else if (Objects.equals(categorie, "bâtons")) {
      return otherController.generateBaton(puissance);
    } else if (Objects.equals(categorie, "objets merveilleux")) {
      return otherController.generateMerveilleux(puissance);
    } else if (Objects.equals(categorie, "parchemins")) {
      return parcheminController.generate(puissance);
    } else if (Objects.equals(categorie, "potions et huiles")) {
      return otherController.generatePotionHuile(puissance);
    } else if (Objects.equals(categorie, "sceptres")) {
      return otherController.generateSceptre(puissance);
    }
    throw new NoSuchElementException(categorie);
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
