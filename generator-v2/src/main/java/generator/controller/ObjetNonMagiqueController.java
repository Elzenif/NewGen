package generator.controller;

import commons.model.dice.Dice;
import generator.model.entity.Arme;
import generator.model.entity.ObjetNonMagique;
import generator.model.repository.ObjetNonMagiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ObjetNonMagiqueController extends AbstractController {

  private final ObjetNonMagiqueRepository objetNonMagiqueRepository;
  private final ArmeController armeController;

  @Autowired
  public ObjetNonMagiqueController(ObjetNonMagiqueRepository objetNonMagiqueRepository, ArmeController armeController) {
    this.objetNonMagiqueRepository = objetNonMagiqueRepository;
    this.armeController = armeController;
  }

  public String generate() {
    int r1 = roll100();
    int r2 = roll100();
    int r3 = roll100();
    ObjetNonMagique objetNonMagique = objetNonMagiqueRepository.findObjetNonMagique(r1, r2, r3);
    String objet = objetNonMagique.getObjet();
    if (Objects.equals(objetNonMagique.getCategorie(), "objet spécial")) {
      Optional<Integer> nb = Dice.getRollFromString(objet);
      return nb.map(i -> objet.replaceFirst(Dice.REGEXP, String.valueOf(i))).orElse(objet);
    } else if (Objects.equals(objetNonMagique.getCategorie(), "armure")) {
      String size = roll100() <= 10 ? "P" : "M";
      return objet + " (" + size + ")";
    } else if (Objects.equals(objetNonMagique.getCategorie(), "arme")) {
      Arme arme = armeController.generateArme(objet);
      return arme.getArme() + " (" + arme.getPrix() + "po)";
    }
    return objet;
  }
}
