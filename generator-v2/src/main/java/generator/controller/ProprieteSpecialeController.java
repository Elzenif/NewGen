package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.ProprieteSpeciale;
import generator.model.repository.ProprieteSpecialeArmeCacRepository;
import generator.model.repository.ProprieteSpecialeArmeDistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ProprieteSpecialeController {

  private final ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository;
  private final ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository;

  @Autowired
  public ProprieteSpecialeController(ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository,
                                     ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository) {
    this.proprieteSpecialeArmeCacRepository = proprieteSpecialeArmeCacRepository;
    this.proprieteSpecialeArmeDistanceRepository = proprieteSpecialeArmeDistanceRepository;
  }

  // TODO add checks to see if the Propriete is compatible with the Arme
  public List<ProprieteSpeciale> generateProprieteSpecialeArme(String puissance, boolean isCac) {
    List<ProprieteSpeciale> proprieteSpeciales = new ArrayList<>();
    int cpt = 0;
    int max = 10;
    int totalWanted = 1;
    int totalBonus = 0;
    while (proprieteSpeciales.size() < totalWanted && cpt < max) {
      cpt++;
      ProprieteSpeciale proprieteSpeciale;
      int r1 = MathUtils.random(1, 100);
      if (isCac) {
        proprieteSpeciale = proprieteSpecialeArmeCacRepository
                .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      } else {
        proprieteSpeciale = proprieteSpecialeArmeDistanceRepository
                .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(puissance, r1, r1);
      }
      if (proprieteSpeciale.getModificateur() == null) {
        totalWanted++;
      } else if (!proprieteSpeciales.contains(proprieteSpeciale) &&
              totalBonus + proprieteSpeciale.getModificateur() <= 10) {
        proprieteSpeciales.add(proprieteSpeciale);
        totalBonus += proprieteSpeciale.getModificateur();
      }
    }
    return proprieteSpeciales;
  }
}
