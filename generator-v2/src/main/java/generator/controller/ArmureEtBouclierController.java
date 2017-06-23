package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ArmureEtBouclier;
import generator.model.entity.ProprieteSpeciale;
import generator.model.repository.*;
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
      ArmureEtBouclier armureEtBouclier = armureEtBouclierRepository
              .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      if (Objects.equals(armureEtBouclier.getType(), "propriété spéciale")) {
        withProprieteSpeciale = true;
      } else if (Objects.equals(armureEtBouclier.getType(), "armure spécifique")) {
        return generateArmureSpecifique(puissance, withProprieteSpeciale);
      }
    }
    return "ERROR not implemented yet";
  }

  @NotNull
  private String generateArmureSpecifique(String puissance, boolean withProprieteSpeciale) {
    int r2 = MathUtils.random(1, 100);
    ArmureSpecifique armureSpecifique = armureSpecifiqueRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r2, r2);
    int prix = armureSpecifique.getPrix();
    String propString = "";
    String bonusString = "";
    if (withProprieteSpeciale) {
      List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController
              .generateProprieteSpecialeArmure(puissance, 0);

    }
    return armureSpecifique.getArme() + bonusString + propString + " (" + prix + "po)";
  }
}
