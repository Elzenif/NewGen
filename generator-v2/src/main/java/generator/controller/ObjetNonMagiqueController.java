package generator.controller;

import commons.model.dice.Dice;
import commons.utils.MathUtils;
import generator.model.entity.Arme;
import generator.model.entity.ObjetNonMagique;
import generator.model.repository.ArmeCorpsACorpsRepository;
import generator.model.repository.ArmeDistanceRepository;
import generator.model.repository.ArmeInhabituelleRepository;
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
public class ObjetNonMagiqueController {

  private final ObjetNonMagiqueRepository objetNonMagiqueRepository;
  private final ArmeCorpsACorpsRepository armeCorpsACorpsRepository;
  private final ArmeInhabituelleRepository armeInhabituelleRepository;
  private final ArmeDistanceRepository armeDistanceRepository;

  @Autowired
  public ObjetNonMagiqueController(ObjetNonMagiqueRepository objetNonMagiqueRepository,
                                   ArmeCorpsACorpsRepository armeCorpsACorpsRepository,
                                   ArmeInhabituelleRepository armeInhabituelleRepository,
                                   ArmeDistanceRepository armeDistanceRepository) {
    this.objetNonMagiqueRepository = objetNonMagiqueRepository;
    this.armeCorpsACorpsRepository = armeCorpsACorpsRepository;
    this.armeInhabituelleRepository = armeInhabituelleRepository;
    this.armeDistanceRepository = armeDistanceRepository;
  }

  public String generate() {
    int r1 = MathUtils.random(1, 100);
    int r2 = MathUtils.random(1, 100);
    int r3 = MathUtils.random(1, 100);
    ObjetNonMagique objetNonMagique = objetNonMagiqueRepository.findObjetNonMagique(r1, r2, r3);
    String objet = objetNonMagique.getObjet();
    if (Objects.equals(objetNonMagique.getCategorie(), "objet spécial")) {
      Optional<Integer> nb = Dice.getRollFromString(objet);
      return nb.map(i -> objet.replaceFirst(Dice.REGEXP, String.valueOf(i))).orElse(objet);
    } else if (Objects.equals(objetNonMagique.getCategorie(), "armure")) {
      String size = MathUtils.random(1, 100) <= 10 ? "P" : "M";
      return objet + " (" + size + ")";
    } else if (Objects.equals(objetNonMagique.getCategorie(), "arme")) {
      Optional<Arme> arme = generateArme(objet);
      return arme.map(a -> a.getArme() + " (" + a.getPrix() + "po)").orElse("ERROR");
    }
    return objet;
  }

  private Optional<Arme> generateArme(String objet) {
    int r4 = MathUtils.random(1, 100);
    Arme arme = null;
    if (Objects.equals(objet, "arme de corps à corps usuelle de maître")) {
      arme = armeCorpsACorpsRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
    } else if (Objects.equals(objet, "arme inhabituelle de maître")) {
      arme = armeInhabituelleRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
    } else if (Objects.equals(objet, "arme à distance usuelle de maître")) {
      int r5 = MathUtils.random(1, 100);
      arme = armeDistanceRepository.findArmeDistance(r4, r5);
    }
    return Optional.ofNullable(arme);
  }
}
