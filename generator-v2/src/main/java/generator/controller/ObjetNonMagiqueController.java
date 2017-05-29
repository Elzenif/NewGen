package generator.controller;

import commons.model.dice.Dice;
import commons.utils.MathUtils;
import generator.model.entity.ObjetNonMagique;
import generator.model.repository.ObjetNonMagiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Germain on 28/05/2017.
 */
@Service
public class ObjetNonMagiqueController {

  private final ObjetNonMagiqueRepository objetNonMagiqueRepository;

  @Autowired
  public ObjetNonMagiqueController(ObjetNonMagiqueRepository objetNonMagiqueRepository) {
    this.objetNonMagiqueRepository = objetNonMagiqueRepository;
  }

  public String generate() {
    int r1 = MathUtils.random(1, 100);
    int r2 = MathUtils.random(1, 100);
    int r3 = MathUtils.random(1, 100);
    ObjetNonMagique objetNonMagique = objetNonMagiqueRepository.findObjetNonMagique(r1, r2, r3);
    String objet = objetNonMagique.getObjet();
    if (Objects.equals(objetNonMagique.getCategorie(), "objet spécial")) {
      Optional<Integer> nb = Dice.getRollFromString(objet);
      return nb.isPresent() ? objet.replaceFirst(Dice.REGEXP, String.valueOf(nb)) : objet;
    } else if (Objects.equals(objetNonMagique.getCategorie(), "armure")) {
      String size = MathUtils.random(1, 100) <= 10 ? "P" : "M";
      return objet + " (" + size + ")";
    } else if (Objects.equals(objetNonMagique.getCategorie(), "arme")) {
      return "ARME";
    }
    return objet;
  }
}
