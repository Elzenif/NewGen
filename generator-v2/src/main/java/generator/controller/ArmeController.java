package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.*;
import generator.model.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
  private final ProprieteSpecialeController proprieteSpecialeController;

  @Autowired
	public ArmeController(ArmeBonusRepository armeBonusRepository, ArmeSpecifiqueRepository armeSpecifiqueRepository,
                        AdversaireDesigneRepository adversaireDesigneRepository, TypeArmeRepository typeArmeRepository,
                        ArmeCorpsACorpsRepository armeCorpsACorpsRepository,
                        ArmeInhabituelleRepository armeInhabituelleRepository,
                        ArmeDistanceRepository armeDistanceRepository,
                        ProprieteSpecialeController proprieteSpecialeController) {
		this.armeBonusRepository = armeBonusRepository;
		this.armeSpecifiqueRepository = armeSpecifiqueRepository;
		this.adversaireDesigneRepository = adversaireDesigneRepository;
    this.typeArmeRepository = typeArmeRepository;
    this.armeCorpsACorpsRepository = armeCorpsACorpsRepository;
    this.armeInhabituelleRepository = armeInhabituelleRepository;
    this.armeDistanceRepository = armeDistanceRepository;
    this.proprieteSpecialeController = proprieteSpecialeController;
  }

	public String generate(String puissance) {
    int cpt = 0;
    int max = 10;
    boolean withProprieteSpeciale = false;
    while (cpt < max) {
      cpt++;
      int r1 = MathUtils.random(1, 100);
      ArmeBonus armeBonus = armeBonusRepository
              .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      if (Objects.equals(armeBonus.getBonus(), "propriété spéciale")) {
        withProprieteSpeciale = true;
      } else if (Objects.equals(armeBonus.getBonus(), "arme spécifique")) {
        return generateArmeSpecifique(puissance, withProprieteSpeciale);
      } else {
        return generateArme(puissance, armeBonus, withProprieteSpeciale);
      }
    }
    return "ERROR generating Arme, try again";
  }

  @NotNull
  private String generateArme(String puissance, ArmeBonus armeBonus, boolean withProprieteSpeciale) {
    int r4 = MathUtils.random(1, 100);
    TypeArme typeArme = typeArmeRepository.findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r4, r4);
    Arme arme = generateArme(typeArme.getType());
    int bonus = Integer.parseInt(armeBonus.getBonus());
    int prix = arme.getPrix();
    String propString = "";
    String bonusString;
    if (withProprieteSpeciale) {
      List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController
              .generateProprieteSpecialeArme(puissance, arme, bonus);
      bonus += proprieteSpeciales.stream().mapToInt(ProprieteSpeciale::getModificateur).sum();
      ArmeBonus trueArmeBonus = armeBonusRepository.findFirstByBonus(String.valueOf(bonus));
      prix += trueArmeBonus.getPrixBase();
      propString = " " + proprieteSpeciales.stream()
              .map(ProprieteSpeciale::getNom)
              .collect(Collectors.joining(", "));
    } else {
      prix += armeBonus.getPrixBase();
    }
    bonusString = " +" + bonus;
    return arme.getArme() + bonusString + propString + " (" + prix + "po)";
  }

  @NotNull
  private String generateArmeSpecifique(String puissance, boolean withProprieteSpeciale) {
    int r2 = MathUtils.random(1, 100);
    ArmeSpecifique armeSpecifique = armeSpecifiqueRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r2, r2);
    String adversaireString = "";
    if (armeSpecifique.getArme().contains("flèche mortelle")) {
      int r3 = MathUtils.random(1, 100);
      AdversaireDesigne adversaireDesigne = adversaireDesigneRepository
              .findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r3, r3);
      adversaireString = "( " + adversaireDesigne.getAdversaire() + ")";
    }
    int prix = armeSpecifique.getPrix();
    String propString = "";
    String bonusString = "";
    if (withProprieteSpeciale) {
      List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController
              .generateProprieteSpecialeArme(puissance, armeSpecifique, 0);
      int bonus = proprieteSpeciales.stream().mapToInt(ProprieteSpeciale::getModificateur).sum();
      bonusString = " +" + bonus;
      ArmeBonus trueArmeBonus = armeBonusRepository.findFirstByBonus(String.valueOf(bonus));
      prix += trueArmeBonus.getPrixBase();
      propString = " " + proprieteSpeciales.stream()
              .map(ProprieteSpeciale::getNom)
              .collect(Collectors.joining(", "));
    }
    return armeSpecifique.getArme() + adversaireString + bonusString + propString + " (" + prix + "po)";
  }

  @NotNull
  public Arme generateArme(String type) {
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
    if (arme == null) {
      throw new RuntimeException("Could not find any arme");
    }
    return arme;
  }
}
