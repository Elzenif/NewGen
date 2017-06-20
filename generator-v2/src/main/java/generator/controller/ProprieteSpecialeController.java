package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.AdversaireDesigne;
import generator.model.entity.Arme;
import generator.model.entity.ProprieteSpeciale;
import generator.model.repository.AdversaireDesigneRepository;
import generator.model.repository.ProprieteSpecialeArmeCacRepository;
import generator.model.repository.ProprieteSpecialeArmeDistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ProprieteSpecialeController {

  private final ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository;
  private final ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository;
  private final ArmeInfoController armeInfoController;
  private final AdversaireDesigneRepository adversaireDesigneRepository;

  @Autowired
  public ProprieteSpecialeController(ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository,
                                     ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository,
                                     ArmeInfoController armeInfoController,
                                     AdversaireDesigneRepository adversaireDesigneRepository) {
    this.proprieteSpecialeArmeCacRepository = proprieteSpecialeArmeCacRepository;
    this.proprieteSpecialeArmeDistanceRepository = proprieteSpecialeArmeDistanceRepository;
    this.armeInfoController = armeInfoController;
    this.adversaireDesigneRepository = adversaireDesigneRepository;
  }

  public List<ProprieteSpeciale> generateProprieteSpecialeArme(String puissance, Arme arme) {
    List<ProprieteSpeciale> proprieteSpeciales = new ArrayList<>();
    int cpt = 0;
    int max = 10;
    int totalWanted = 1;
    int totalBonus = 0;
    while (proprieteSpeciales.size() < totalWanted && cpt < max) {
      cpt++;
      ProprieteSpeciale proprieteSpeciale;
      int r1 = MathUtils.random(1, 100);
      if (arme.isCac()) {
        proprieteSpeciale = proprieteSpecialeArmeCacRepository
                .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      } else {
        proprieteSpeciale = proprieteSpecialeArmeDistanceRepository
                .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      }
      if (proprieteSpeciale.getModificateur() == null) {
        totalWanted++;
      } else if (!proprieteSpeciales.contains(proprieteSpeciale) &&
              totalBonus + proprieteSpeciale.getModificateur() <= 10 &&
              armeInfoController.isCompatible(arme, proprieteSpeciale)) {
        if (Objects.equals(proprieteSpeciale.getNom(), "tueuse")) {
          int r2 = MathUtils.random(1, 100);
          AdversaireDesigne adversaireDesigne = adversaireDesigneRepository
                  .findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(r2, r2);
          proprieteSpeciale.setNom("tueuse (" + adversaireDesigne.getAdversaire() + ")");
        }
        proprieteSpeciales.add(proprieteSpeciale);
        totalBonus += proprieteSpeciale.getModificateur();
      }
    }
    return proprieteSpeciales;
  }
}
