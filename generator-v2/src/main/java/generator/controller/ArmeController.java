package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.*;
import generator.model.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ArmeController {

	private final ArmeBonusRepository armeBonusRepository;
	private final ArmeSpecifiqueRepository armeSpecifiqueRepository;
	private final AdversaireDesigneRepository adversaireDesigneRepository;
  private final TypeArmeRepository typeArmeRepository;
  private final ArmeCorpsACorpsRepository armeCorpsACorpsRepository;
  private final ArmeInhabituelleRepository armeInhabituelleRepository;
  private final ArmeDistanceRepository armeDistanceRepository;

  @Autowired
	public ArmeController(ArmeBonusRepository armeBonusRepository, ArmeSpecifiqueRepository armeSpecifiqueRepository,
                        AdversaireDesigneRepository adversaireDesigneRepository, TypeArmeRepository typeArmeRepository,
                        ArmeCorpsACorpsRepository armeCorpsACorpsRepository,
                        ArmeInhabituelleRepository armeInhabituelleRepository,
                        ArmeDistanceRepository armeDistanceRepository) {
		this.armeBonusRepository = armeBonusRepository;
		this.armeSpecifiqueRepository = armeSpecifiqueRepository;
		this.adversaireDesigneRepository = adversaireDesigneRepository;
    this.typeArmeRepository = typeArmeRepository;
    this.armeCorpsACorpsRepository = armeCorpsACorpsRepository;
    this.armeInhabituelleRepository = armeInhabituelleRepository;
    this.armeDistanceRepository = armeDistanceRepository;
  }

	public String generate(String puissance) {
    int r1 = MathUtils.random(1, 100);
    ArmeBonus armeBonus = armeBonusRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
    if (Objects.equals(armeBonus.getBonus(), "arme spécifique")) {
      return generateArmeSpecifique(puissance);
    } else {
      int r4 = MathUtils.random(1, 100);
      TypeArme typeArme = typeArmeRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
      Optional<Arme> arme = generateArme(typeArme.getType());
      if (Objects.equals(armeBonus.getBonus(), "propriété spéciale")) {
        return "ERROR, 'propriété spéciale' not taken into account";
      } else {
        int prix = armeBonus.getPrixBase();
        int bonus = Integer.parseInt(armeBonus.getBonus());
        return arme.map(a -> a.getArme() + bonus + " (" + a.getPrix() + prix + "po)").orElse("ERROR");
      }
    }
  }

  @NotNull
  private String generateArmeSpecifique(String puissance) {
    int r2 = MathUtils.random(1, 100);
    ArmeSpecifique armeSpecifique = armeSpecifiqueRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r2, r2);
    if (Objects.equals(armeSpecifique.getArme(), "flèche mortelle")) {
      int r3 = MathUtils.random(1, 100);
      AdversaireDesigne adversaireDesigne = adversaireDesigneRepository
              .findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r3, r3);
      return armeSpecifique.getArme() + " (" + adversaireDesigne.getAdversaire() + ") (" + armeSpecifique.getPrix() + "po)";
    }
    return armeSpecifique.getArme() + " (" + armeSpecifique.getPrix() + "po)";
  }

  public Optional<Arme> generateArme(String type) {
    int r4 = MathUtils.random(1, 100);
    Arme arme = null;
    if (type.contains("arme de corps à corps usuelle")) {
      arme = armeCorpsACorpsRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
    } else if (type.contains("arme inhabituelle")) {
      arme = armeInhabituelleRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
    } else if (type.contains("arme à distance usuelle")) {
      int r5 = MathUtils.random(1, 100);
      arme = armeDistanceRepository.findArmeDistance(r4, r5);
    }
    return Optional.ofNullable(arme);  }
}
