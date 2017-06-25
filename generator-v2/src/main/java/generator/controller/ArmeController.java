package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.AdversaireDesigne;
import generator.model.entity.Arme;
import generator.model.entity.ArmeBonus;
import generator.model.entity.ArmeSpecifique;
import generator.model.entity.ProprieteSpeciale;
import generator.model.entity.TypeArme;
import generator.model.repository.AdversaireDesigneRepository;
import generator.model.repository.ArmeBonusRepository;
import generator.model.repository.ArmeCorpsACorpsRepository;
import generator.model.repository.ArmeDistanceRepository;
import generator.model.repository.ArmeInhabituelleRepository;
import generator.model.repository.ArmeSpecifiqueRepository;
import generator.model.repository.TypeArmeRepository;
import generator.utils.GeneratorUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
      ArmeBonus armeBonus = armeBonusRepository.findRandomByPuissance(puissance, r1);
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
    int r = MathUtils.random(1, 100);
    TypeArme typeArme = typeArmeRepository.findRandom(r);
    Arme arme = generateArme(typeArme.getType());
    int bonus = Integer.parseInt(armeBonus.getBonus());
    int prix = arme.getPrix();
    String propString = "";
    String bonusString;
    if (withProprieteSpeciale) {
      List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController
          .generateProprieteSpecialeArme(puissance, arme, bonus);
      bonus += GeneratorUtils.getTotalBonus(proprieteSpeciales);
      ArmeBonus trueArmeBonus = armeBonusRepository.findFirstByBonus(String.valueOf(bonus));
      prix += trueArmeBonus.getPrixBase();
      propString = GeneratorUtils.getProprietes(proprieteSpeciales);
    } else {
      prix += armeBonus.getPrixBase();
    }
    bonusString = " +" + bonus;
    return arme.getArme() + bonusString + propString + " (" + prix + "po)";
  }

  @NotNull
  private String generateArmeSpecifique(String puissance, boolean withProprieteSpeciale) {
    int r2 = MathUtils.random(1, 100);
    ArmeSpecifique armeSpecifique = armeSpecifiqueRepository.findRandomByPuissance(puissance, r2);
    String adversaireString = "";
    if (armeSpecifique.getArme().contains("flèche mortelle")) {
      int r3 = MathUtils.random(1, 100);
      AdversaireDesigne adversaireDesigne = adversaireDesigneRepository.findRandom(r3);
      adversaireString = "( " + adversaireDesigne.getAdversaire() + ")";
    }
    int prix = armeSpecifique.getPrix();
    String propString = "";
    String bonusString = "";
    if (withProprieteSpeciale) {
      List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController
          .generateProprieteSpecialeArme(puissance, armeSpecifique, 0);
      int bonus = GeneratorUtils.getTotalBonus(proprieteSpeciales);
      bonusString = " +" + bonus;
      ArmeBonus trueArmeBonus = armeBonusRepository.findFirstByBonus(String.valueOf(bonus));
      prix += trueArmeBonus.getPrixBase();
      propString = GeneratorUtils.getProprietes(proprieteSpeciales);
    }
    return armeSpecifique.getArme() + adversaireString + bonusString + propString + " (" + prix + "po)";
  }

  @NotNull
  public Arme generateArme(String type) {
    int r4 = MathUtils.random(1, 100);
    Arme arme = null;
    if (type.contains("arme de corps à corps usuelle")) {
      arme = armeCorpsACorpsRepository.findRandom(r4);
    } else if (type.contains("arme inhabituelle")) {
      arme = armeInhabituelleRepository.findRandom(r4);
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
