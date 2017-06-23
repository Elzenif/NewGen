package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ArmureEtBouclier;
import generator.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    int r1 = MathUtils.random(1, 100);
    ArmureEtBouclier armureEtBouclier = armureEtBouclierRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
    if (Objects.equals(armureEtBouclier.getType(), "armure spécifique")) {

    }
    return "ERROR not implemented yet";
  }
}
