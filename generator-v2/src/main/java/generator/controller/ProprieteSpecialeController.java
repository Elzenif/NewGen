package generator.controller;

import generator.model.entity.AdversaireDesigne;
import generator.model.entity.Arme;
import generator.model.entity.ArmeSpecifique;
import generator.model.entity.IArme;
import generator.model.entity.ProprieteSpeciale;
import generator.model.entity.ProprieteSpecialePrix;
import generator.model.repository.AdversaireDesigneRepository;
import generator.model.repository.ProprieteSpecialeArmeCacRepository;
import generator.model.repository.ProprieteSpecialeArmeDistanceRepository;
import generator.model.repository.ProprieteSpecialeArmureRepository;
import generator.model.repository.ProprieteSpecialeBouclierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ProprieteSpecialeController extends AbstractController {

  private final ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository;
  private final ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository;
  private final ArmeInfoController armeInfoController;
  private final AdversaireDesigneRepository adversaireDesigneRepository;
  private final ProprieteSpecialeArmureRepository proprieteSpecialeArmureRepository;
  private final ProprieteSpecialeBouclierRepository proprieteSpecialeBouclierRepository;


  @Autowired
  public ProprieteSpecialeController(ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository,
                                     ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository,
                                     ProprieteSpecialeArmureRepository proprieteSpecialeArmureRepository,
                                     ProprieteSpecialeBouclierRepository proprieteSpecialeBouclierRepository,
                                     ArmeInfoController armeInfoController,
                                     AdversaireDesigneRepository adversaireDesigneRepository) {
    this.proprieteSpecialeArmeCacRepository = proprieteSpecialeArmeCacRepository;
    this.proprieteSpecialeArmeDistanceRepository = proprieteSpecialeArmeDistanceRepository;
    this.proprieteSpecialeArmureRepository = proprieteSpecialeArmureRepository;
    this.proprieteSpecialeBouclierRepository = proprieteSpecialeBouclierRepository;
    this.armeInfoController = armeInfoController;
    this.adversaireDesigneRepository = adversaireDesigneRepository;
  }

  public List<ProprieteSpeciale> generateProprieteSpecialeArme(String puissance, IArme arme, int bonus) {
    List<ProprieteSpeciale> proprieteSpeciales = new ArrayList<>();
    int cpt = 0;
    int max = 10;
    int totalWanted = 1;
    int totalBonus = bonus;
    while (proprieteSpeciales.size() < totalWanted && cpt < max) {
      cpt++;
      ProprieteSpeciale proprieteSpeciale;
      proprieteSpeciale = getProprieteSpeciale(puissance, arme.isCac());
      if (proprieteSpeciale.getModificateur() == null) {
        totalWanted++;
      } else if (!proprieteSpeciales.contains(proprieteSpeciale) &&
          totalBonus + proprieteSpeciale.getModificateur() <= 10 &&
          checkCompatibility(arme, proprieteSpeciale)) {
        if (Objects.equals(proprieteSpeciale.getNom(), "tueuse")) {
          AdversaireDesigne adversaireDesigne = adversaireDesigneRepository.findRandom(roll100());
          proprieteSpeciale.setNom("tueuse (" + adversaireDesigne.getAdversaire() + ")");
        }
        proprieteSpeciales.add(proprieteSpeciale);
        totalBonus += proprieteSpeciale.getModificateur();
      }
    }
    return proprieteSpeciales;
  }

  private ProprieteSpeciale getProprieteSpeciale(String puissance, boolean isCac) {
    ProprieteSpeciale proprieteSpeciale;
    int r = roll100();
    if (isCac) {
      proprieteSpeciale = proprieteSpecialeArmeCacRepository.findRandomByPuissance(puissance, r);
    } else {
      proprieteSpeciale = proprieteSpecialeArmeDistanceRepository.findRandomByPuissance(puissance, r);
    }
    return proprieteSpeciale;
  }

  public List<ProprieteSpecialePrix> generateProprieteSpecialeArmureBouclier(String puissance, int bonus,
                                                                             boolean isArmure) {
    List<ProprieteSpecialePrix> proprieteSpeciales = new ArrayList<>();
    int cpt = 0;
    int max = 10;
    int totalWanted = 1;
    int totalBonus = bonus;
    while (proprieteSpeciales.size() < totalWanted && cpt < max) {
      cpt++;
      ProprieteSpecialePrix proprieteSpeciale = getProprieteSpecialeArmureBouclier(puissance, isArmure);
      if (Objects.equals(proprieteSpeciale.getNom(), "rejouez deux fois le dé")) {
        totalWanted++;
      } else if (!proprieteSpeciales.contains(proprieteSpeciale)) {
        if (proprieteSpeciale.getModificateur() == null) {
          proprieteSpeciales.add(proprieteSpeciale);
        } else if (totalBonus + proprieteSpeciale.getModificateur() <= 10) {
          proprieteSpeciales.add(proprieteSpeciale);
          totalBonus += proprieteSpeciale.getModificateur();
        }
      }
    }
    return proprieteSpeciales;
  }

   private ProprieteSpecialePrix getProprieteSpecialeArmureBouclier(String puissance, boolean isArmure) {
    ProprieteSpecialePrix proprieteSpeciale;
    int r = roll100();
    if (isArmure) {
      proprieteSpeciale = proprieteSpecialeArmureRepository.findRandomByPuissance(puissance, r);
    } else {
      proprieteSpeciale = proprieteSpecialeBouclierRepository.findRandomByPuissance(puissance, r);
    }
    return proprieteSpeciale;
  }

  private boolean checkCompatibility(IArme arme, ProprieteSpeciale proprieteSpeciale) {
    if (arme instanceof Arme) {
      return armeInfoController.isCompatible((Arme) arme, proprieteSpeciale);
    } else if (arme instanceof ArmeSpecifique) {
      return armeInfoController.isCompatible((ArmeSpecifique) arme, proprieteSpeciale);
    }
    return true;
  }
}