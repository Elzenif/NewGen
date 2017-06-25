package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ArmureEtBouclier;
import generator.model.entity.ObjetSpecifique;
import generator.model.entity.ProprieteSpecialePrix;
import generator.model.entity.TypeObjetPrix;
import generator.model.repository.ArmureEtBouclierRepository;
import generator.model.repository.ArmureSpecifiqueRepository;
import generator.model.repository.BouclierSpecifiqueRepository;
import generator.model.repository.TypeArmureRepository;
import generator.model.repository.TypeBouclierRepository;
import generator.utils.GeneratorUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ArmureEtBouclierController {

  private final ArmureEtBouclierRepository armureEtBouclierRepository;
  private final ArmureSpecifiqueRepository armureSpecifiqueRepository;
  private final BouclierSpecifiqueRepository bouclierSpecifiqueRepository;
  private final TypeArmureRepository typeArmureRepository;
  private final TypeBouclierRepository typeBouclierRepository;
  private final ProprieteSpecialeController proprieteSpecialeController;

  @Autowired
  public ArmureEtBouclierController(ArmureEtBouclierRepository armureEtBouclierRepository,
                                    ArmureSpecifiqueRepository armureSpecifiqueRepository,
                                    BouclierSpecifiqueRepository bouclierSpecifiqueRepository,
                                    TypeArmureRepository typeArmureRepository,
                                    TypeBouclierRepository typeBouclierRepository,
                                    ProprieteSpecialeController proprieteSpecialeController) {
    this.armureEtBouclierRepository = armureEtBouclierRepository;
    this.armureSpecifiqueRepository = armureSpecifiqueRepository;
    this.bouclierSpecifiqueRepository = bouclierSpecifiqueRepository;
    this.typeArmureRepository = typeArmureRepository;
    this.typeBouclierRepository = typeBouclierRepository;
    this.proprieteSpecialeController = proprieteSpecialeController;
  }

  public String generate(String puissance) {
    int cpt = 0;
    int max = 10;
    boolean withProprieteSpeciale = false;
    while (cpt < max) {
      cpt++;
      int r1 = MathUtils.random(1, 100);
      ArmureEtBouclier armureEtBouclier = armureEtBouclierRepository.findRandomByPuissance(puissance, r1);
      if (Objects.equals(armureEtBouclier.getType(), "propriété spéciale")) {
        withProprieteSpeciale = true;
      } else if (Objects.equals(armureEtBouclier.getType(), "armure spécifique")) {
        return generateSpecifique(puissance, withProprieteSpeciale, true);
      } else if (Objects.equals(armureEtBouclier.getType(), "bouclier spécifique")) {
        return generateSpecifique(puissance, withProprieteSpeciale, false);
      } else if (Objects.equals(armureEtBouclier.getType(), "armure")) {
        return generateArmureBouclier(puissance, withProprieteSpeciale, armureEtBouclier, true);
      } else {
        return generateArmureBouclier(puissance, withProprieteSpeciale, armureEtBouclier, false);
      }
    }
    return "ERROR generating ArmureBouclier, try again";
  }

  @NotNull
  private String generateArmureBouclier(String puissance, boolean withProprieteSpeciale,
                                        ArmureEtBouclier armureEtBouclier, boolean isArmure) {
    TypeObjetPrix typeObjet = getTypeObjet(isArmure);
    int prix = typeObjet.getPrix();
    int bonus = armureEtBouclier.getModificateur();
    String propString = "";
    String bonusString;
    if (withProprieteSpeciale) {
      List<ProprieteSpecialePrix> proprieteSpeciales = proprieteSpecialeController
          .generateProprieteSpecialeArmureBouclier(puissance, bonus, isArmure);
      bonus += GeneratorUtils.getTotalBonus(proprieteSpeciales);
      if (bonus > armureEtBouclier.getModificateur()) {
        prix += armureEtBouclierRepository.findFirstByModificateur(bonus).getPrix();
      }
      prix += GeneratorUtils.getTotalPrix(proprieteSpeciales);
      propString = GeneratorUtils.getProprietes(proprieteSpeciales);
    }
    bonusString = " +" + bonus;
    return typeObjet.getType() + bonusString + propString + " (" + prix + "po)";
  }

  private TypeObjetPrix getTypeObjet(boolean isArmure) {
    TypeObjetPrix typeObjet;
    int r = MathUtils.random(1, 100);
    if (isArmure) {
      typeObjet = typeArmureRepository.findRandom(r);
    } else {
      typeObjet = typeBouclierRepository.findRandom(r);
    }
    return typeObjet;
  }

  @NotNull
  private String generateSpecifique(String puissance, boolean withProprieteSpeciale, boolean isArmure) {
    ObjetSpecifique objetSpecifique;
    objetSpecifique = getObjetSpecifique(puissance, isArmure);
    int prix = objetSpecifique.getPrix();
    String propString = "";
    String bonusString = "";
    if (withProprieteSpeciale) {
      List<ProprieteSpecialePrix> proprieteSpeciales = proprieteSpecialeController
          .generateProprieteSpecialeArmureBouclier(puissance, 0, isArmure);
      int bonus = GeneratorUtils.getTotalBonus(proprieteSpeciales);
      if (bonus > 0) {
        bonusString = " +" + bonus;
        ArmureEtBouclier armureEtBouclier = armureEtBouclierRepository.findFirstByModificateur(bonus);
        prix += armureEtBouclier.getPrix();
      }
      prix += GeneratorUtils.getTotalPrix(proprieteSpeciales);
      propString = GeneratorUtils.getProprietes(proprieteSpeciales);
    }
    return objetSpecifique.getArme() + bonusString + propString + " (" + prix + "po)";
  }

  private ObjetSpecifique getObjetSpecifique(String puissance, boolean isArmure) {
    ObjetSpecifique objetSpecifique;
    int r = MathUtils.random(1, 100);
    if (isArmure) {
      objetSpecifique = armureSpecifiqueRepository.findRandomByPuissance(puissance, r);
    } else {
      objetSpecifique = bouclierSpecifiqueRepository.findRandomByPuissance(puissance, r);
    }
    return objetSpecifique;
  }
}
